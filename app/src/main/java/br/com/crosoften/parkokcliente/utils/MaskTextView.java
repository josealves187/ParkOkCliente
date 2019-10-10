package br.com.crosoften.parkokcliente.utils;

public abstract class MaskTextView {

    public  static String cpf(String cpfTextView) {
        String bloco1 = cpfTextView.substring(0,3);
//        String bloco2 = cpfTextView.substring(3,6);
//        String bloco3 = cpfTextView.substring(6,9);
//        String bloco4 = cpfTextView.substring(9,11);

        if (cpfTextView != null && cpfTextView.length() == 11)
       // return bloco1 + "." + bloco2 + "." + bloco3 + "-"+bloco4;
            return bloco1  + " ***" + "." + "***" +"-"+ "**";
        else return "";

    }

    public  static String cpfRegistration(String cpfTextView) {
        String bloco1 = cpfTextView.substring(0,3);
        String bloco2 = cpfTextView.substring(3,6);
        String bloco3 = cpfTextView.substring(6,9);
        String bloco4 = cpfTextView.substring(9,11);

        if (cpfTextView != null && cpfTextView.length() == 11)
            return bloco1 + "." + bloco2 + "." + bloco3 + "-"+bloco4;
        else return "";

    }

    public static String boad(String boadTetView){
        if (boadTetView == null || boadTetView.length() != 7)
            return  "";


        String b1 = boadTetView.substring(0,3);
        String b2 = boadTetView.substring(3,7);
        return b1 + "-" + b2;
    }
}
