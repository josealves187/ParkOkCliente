package br.com.crosoften.parkokcliente.view.fragmenst;


import android.Manifest;
import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.content.pm.PackageManager;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.core.content.ContextCompat;
import androidx.fragment.app.Fragment;

import com.google.android.gms.maps.CameraUpdate;
import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.MapView;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.model.BitmapDescriptorFactory;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.LatLngBounds;
import com.google.android.gms.maps.model.Marker;
import com.google.android.gms.maps.model.MarkerOptions;

import br.com.crosoften.parkokcliente.R;
import br.com.crosoften.parkokcliente.utils.PermitirLocalizacao;
import br.com.crosoften.parkokcliente.view.activities.ParkingDetailsActivity;
import br.com.crosoften.parkokcliente.view.adapters.ParkingDetailsPaymentAdapter;

/**
 * A simple {@link Fragment} subclass.
 */
public class MapFragment extends Fragment implements GoogleMap.OnMarkerClickListener, OnMapReadyCallback {

    private static final int LOCATION_PERMISSION_REQUEST_CODE = 1;
    private static final LatLng PERTH = new LatLng(-18.930337, -48.253140);
    private static final LatLng SYDNEY = new LatLng(-18.929952, -48.253457);
    private static final LatLng BRISBANE = new LatLng(-18.930540, -48.252760);
    private boolean mPermissionDenied = false;

    private MapView mapView;
    private GoogleMap mMap;
    private Marker mPerth;
    private Marker mSydney;
    private Marker mBrisbane;
    private TextView tvSeeDetail;

    public MapFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_map, container, false);
        getActivity().setRequestedOrientation(
                ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);
        tvSeeDetail = view.findViewById(R.id.tv_see_detail);
        mapView = view.findViewById(R.id.map);
        eventoButton();
        mapView.onCreate(savedInstanceState);
        mapView.onResume();
        mapView.getMapAsync(this);//when you already implement OnMapReadyCallback in your fragment_map

        return view;
    }

    @Override
    public void onMapReady(GoogleMap Map) {

        mMap = Map;

        /**Adicione alguns marcadores ao mapa e adicione um objeto de dados a cada marcador.
         */

        mPerth = mMap.addMarker(new MarkerOptions()
                .position(PERTH)
                .title("Park").icon(BitmapDescriptorFactory.fromResource(R.drawable.ic_location)));
        mPerth.setTag(0);

        mSydney = mMap.addMarker(new MarkerOptions()
                .position(SYDNEY)
                .title("Park-ok").icon(BitmapDescriptorFactory.fromResource(R.drawable.ic_location)));
        mSydney.setTag(0);

        mBrisbane = mMap.addMarker(new MarkerOptions()
                .position(BRISBANE)
                .title("Stopark ").icon(BitmapDescriptorFactory.fromResource(R.drawable.ic_location)));
        mBrisbane.setTag(0);


        // Defina um ouvinte para o clique do marcador.
        mMap.setOnMarkerClickListener(this);

        LatLngBounds.Builder builder = new LatLngBounds.Builder();
        // o método include calculará os limites mínimo e máximo da posição
        builder.include(mPerth.getPosition());
        builder.include(mBrisbane.getPosition());
        builder.include(mSydney.getPosition());

        LatLngBounds bounds = builder.build();

        int width = getResources().getDisplayMetrics().widthPixels;
        int height = getResources().getDisplayMetrics().heightPixels;
        int padding = (int) (width * 0.35); // deslocamento das bordas do mapa 10% da tela

        CameraUpdate cameraUpdate = CameraUpdateFactory.newLatLngBounds(bounds, width, height, padding);

        mMap.animateCamera(cameraUpdate);

    }

    private void eventoButton() {
        tvSeeDetail.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(getContext(), ParkingDetailsActivity.class);
                startActivity(i);
            }
        });
    }
    @Override
    public boolean onMarkerClick(final Marker marker) {

        // Recupera os dados do marcador.
        Integer clickCount = (Integer) marker.getTag();


        // Verifique se uma contagem de cliques foi definida e exiba a contagem de cliques.
        if (clickCount != null) {
            clickCount = clickCount + 1;
            marker.setTag(clickCount);
            Toast.makeText(getActivity(),
                    marker.getTitle() +
                            " " + clickCount + " ",
                    Toast.LENGTH_SHORT).show();
        }

        /** // Retorna false para indicar que não consumimos o evento e que desejamos
            // para que o comportamento padrão ocorra (que é para a câmera se mover de modo que o
            // marcador está centralizado e a janela de informações do marcador é aberta, se houver).
         */

        return false;

    }

    /**
     * Retorno de chamada para o resultado da solicitação de permissões. Este método é chamado para
     * todas as chamadas requestPermissions(android.app.Activity, String[], int).
     */

    @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions,
                                           @NonNull int[] grantResults) {
        if (requestCode != LOCATION_PERMISSION_REQUEST_CODE) {
            return;
        }

        if (PermitirLocalizacao.isPermissionGranted(permissions, grantResults,
                Manifest.permission.ACCESS_FINE_LOCATION)) {
            enableMyLocation();
        } else {
            mPermissionDenied = true;
        }
    }

    @Override
    public void onResume() {
        super.onResume();
        if (mPermissionDenied) {
            showMissingPermissionError();
            mPermissionDenied = false;
        }
    }

    private void enableMyLocation() {
        if (ContextCompat.checkSelfPermission(getActivity(), Manifest.permission.ACCESS_FINE_LOCATION)
                != PackageManager.PERMISSION_GRANTED) {
            PermitirLocalizacao.requestPermission(this, LOCATION_PERMISSION_REQUEST_CODE,
                    Manifest.permission.ACCESS_FINE_LOCATION, true);
        } else if (mMap != null) {
            mMap.setMyLocationEnabled(true);
        }
    }

    private void showMissingPermissionError() {
        PermitirLocalizacao.PermissionDeniedDialog
                .newInstance(true).show(getFragmentManager(), "dialog");
    }


}
