package br.com.crosoften.parkokcliente.utils;

import android.annotation.SuppressLint;
import android.content.Context;
import android.os.Build;

import java.text.NumberFormat;
import java.text.SimpleDateFormat;
import java.time.OffsetTime;
import java.util.Calendar;
import java.util.Date;
import java.util.TimeZone;

public abstract class Utils {

    /**
     * Função que retorna formatação dia e mes,
     * baseada em sua localização.
     * @param context Contexto da Aplicação
     * @return Exemplo: 04 SET caso Locale seja PT BR
     * */
    public static String getDayAndMonth(Date date, Context context) {
        String formatDate = "dd MMM";
        SimpleDateFormat simpleDateFormat;
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.N) {
            simpleDateFormat = new SimpleDateFormat(formatDate,
                    (Build.VERSION.SDK_INT >= Build.VERSION_CODES.N) ?
                            context.getResources().getConfiguration().getLocales().get(0)
                            : context.getResources().getConfiguration().locale);
        } else simpleDateFormat = new SimpleDateFormat(formatDate);
        simpleDateFormat.setTimeZone(TimeZone.getTimeZone("UTC"));
        return simpleDateFormat.format(date).toUpperCase();
    }


    /**
     * Função que retorna formatação de hora e minutos,
     * baseada em sua localização.
     * @return Exemplo: 12:57 caso Locale seja PT BR
     * */


    @SuppressLint("SimpleDateFormat")
    public static String dateFormat( Date date){

        long data = System.currentTimeMillis();
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("HH:mm '-' yyyy/MM/dd");
        String dataString = simpleDateFormat.format(data);
        return dataString;
    }

    @SuppressLint("SimpleDateFormat")
    public static String timeFormat( Date date){

        long data = System.currentTimeMillis();
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("h:mm");
        String dataString = simpleDateFormat.format(data);
        return dataString;
    }

//    @SuppressLint("SimpleDateFormat")
//    public static String timeFormat( Date date,Context context){
//
//        String formatDate = "HH:mm";
//        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
//            new SimpleDateFormat(formatDate,
//                    (Build.VERSION.SDK_INT >= Build.VERSION_CODES.N) ?
//                            context.getResources().getConfiguration().getLocales().get(0)
//                            : context.getResources().getConfiguration().locale);
//            OffsetTime offset = OffsetTime.now();
//            return (offset.getHour() + " : " + offset.getMinute()
//            );
//        }
//
//        return "";
//    }


    /**
     * Função que retorna formatação de moeda em um double,
     * baseada em sua localização.
     * @param context Contexto da Aplicação
     * @return Exemplo: R$ 5.000,00 caso Locale seja PT BR
     * */

    public static String formatCurrency(Context context, double value) {
        NumberFormat currencyInstance;
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.N) {
            currencyInstance = NumberFormat.getCurrencyInstance(
                    (Build.VERSION.SDK_INT >= Build.VERSION_CODES.N) ?
                            context.getResources().getConfiguration().getLocales().get(0)
                            : context.getResources().getConfiguration().locale
            );
        } else
            currencyInstance = NumberFormat.getCurrencyInstance();
        return currencyInstance.format(value);

    }
}
