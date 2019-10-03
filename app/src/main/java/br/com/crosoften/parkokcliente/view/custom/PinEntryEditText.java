package br.com.crosoften.parkokcliente.view.custom;

import android.annotation.SuppressLint;
import android.annotation.TargetApi;
import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.os.Build;
import android.text.Editable;
import android.text.TextWatcher;
import android.util.AttributeSet;
import android.util.TypedValue;
import android.view.ActionMode;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.EditText;

import androidx.annotation.ColorInt;
import androidx.annotation.ColorRes;
import androidx.appcompat.widget.AppCompatEditText;

import br.com.crosoften.parkokcliente.R;

@SuppressLint("AppCompatCustomView")
public class PinEntryEditText extends EditText implements
     TextWatcher {

    float mSpace = 24; //24 dp by default
    float mCharSize = 0;
    float mNumChars = 4;
    float mLineSpacing = 8; //8dp by default



//    //definindo a cor das linhas, dependendo do estado do PinEntryEditText.
//
//    private float mLineStroke = 1 ; //1dp por padrão
//
//    private Paint mLinesPaint;
//
//    int[][] mStates = new int[][]{
//            new int[]{android.R.attr.state_selected}, //selecionado
//            new int[]{android.R.attr.state_focused}, //focado
//            new int[]{-android.R.attr.state_focused}, //desfocado
//    };
//
//    int[]mColors = new int[]{
//            Color.BLUE,
//            Color.BLUE,
//            Color.BLUE,
//    };
//
//    ColorStateList mcolorStateList = new ColorStateList(mStates,mColors);
//
//    private int getColorForState(int ... states){
//        return mcolorStateList.getColorForState(states,Color.GRAY);
//    }
//
//
//
//
//    /** next = o caractere atual é o próximo caractere a ser inserido?
//        */
//
//    private void updateColorForLines(boolean next) {
//        if (isFocused()) {
//            mLinesPaint.setColor(
//                    getColorForState(android.R.attr.state_focused));
//            if (next) {
//                mLinesPaint.setColor(
//                        getColorForState(android.R.attr.state_selected));
//            }
//        } else {
//            mLinesPaint.setColor(
//                    getColorForState(-android.R.attr.state_focused));
//        }
//    }




    public PinEntryEditText(Context context) {
        super(context);
    }

    public PinEntryEditText(Context context, AttributeSet attrs) {
        super(context, attrs);
        init(context, attrs);
    }

    public PinEntryEditText(Context context, AttributeSet attrs,
                            int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        init(context, attrs);
    }

    @TargetApi(Build.VERSION_CODES.LOLLIPOP)
    public PinEntryEditText(Context context, AttributeSet attrs,
                            int defStyleAttr, int defStyleRes) {
        super(context, attrs, defStyleAttr, defStyleRes);
        init(context, attrs);
    }

    private OnClickListener mClickListener;
    private void init(Context context, AttributeSet attrs) {
        setBackgroundResource(0);
        float multi = context.getResources().getDisplayMetrics().density;
        mSpace = multi * mSpace; //convert to pixels for our density
        mLineSpacing = multi * mLineSpacing; //convert to pixels
//        mLineStroke = multi * mLineStroke;
//        mLinesPaint = new Paint(getPaint());
//        mLinesPaint.setStrokeWidth(mLineStroke);





        // Desativa  colar e copiar do campo

        super.setCustomSelectionActionModeCallback(
                new  ActionMode.Callback() {
                    public boolean onPrepareActionMode(ActionMode mode, Menu menu) {
                        return false;
                    }

                    public void onDestroyActionMode(ActionMode mode) {
                    }

                    public boolean onCreateActionMode(ActionMode mode,Menu menu) {
                        return false;
                    }

                    public boolean onActionItemClicked(ActionMode mode,MenuItem item) {
                        return false;
                    }
                });
        //When tapped, move cursor to end of the text
        super.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {
                setSelection(getText().length());
                if (mClickListener != null) {
                    mClickListener.onClick(v);
                }
            }
        });
    }

    @Override
    public void setOnClickListener(OnClickListener l) {
        mClickListener = l;
    }

    @Override
    public void setCustomSelectionActionModeCallback(ActionMode.Callback actionModeCallback) {
        throw new RuntimeException("setCustomSelectionActionModeCallback() not supported.");
    }



    @Override
    protected void onDraw(Canvas canvas) {

        //super.onDraw(canvas);
        int availableWidth =
                getWidth() - getPaddingRight() - getPaddingLeft();
        if (mSpace < 0) {
            mCharSize = (availableWidth / (mNumChars * 2 - 1));
        } else {
            mCharSize =
                    (availableWidth - (mSpace * (mNumChars - 1))) / mNumChars;
        }

        int startX = getPaddingLeft();
        int bottom = getHeight() - getPaddingBottom();

        //// Largura do texto

        Editable text = getText();
        int textLength = text.length();
        float[] textWidths = new float[textLength];
        getPaint().getTextWidths(getText(), 0, textLength, textWidths);

        for (int i = 0; i < mNumChars; i++) {

            /** no onDraw, queremos usar mLinePaint para desenhar as linhas em vez do objeto Paint
             * retornado por getPaint (). Também queremos chamar updateColorsForLines (booleano)
             * antes de desenhar cada linha para garantir que a cor correta seja desenhada.
             * */
//            updateColorForLines(i == textLength);
            canvas.drawLine(
                    startX, bottom, startX + mCharSize, bottom, getPaint());

            if (getText().length() > i) {
                float middle = startX + mCharSize / 2;
                canvas.drawText(text,
                        i,
                        i + 1,
                        middle - textWidths[0] / 2,
                        bottom - mLineSpacing,
                        getPaint());
            }
            if (mSpace < 0) {
                startX += mCharSize * 2;
            } else {
                startX += mCharSize + mSpace;
            }
        }
    }

    @Override
    public void beforeTextChanged(CharSequence s, int start, int count, int after) {

    }

    @Override
    public void onTextChanged(CharSequence s, int start, int before, int count) {

    }

    @Override
    public void afterTextChanged(Editable s) {

    }
}