package com.example.rpplaboratorio;
import android.view.View;

public class AutoController implements View.OnClickListener {

    AutoModel auto ;
    AutoView autoView ;

    public AutoModel getAuto() {
        return auto;
    }

    public void setAuto(AutoModel auto) {
        this.auto = auto;
    }

    public AutoView getAutoView() {
        return autoView;
    }

    public void setAutoView(AutoView autoView) {
        this.autoView = autoView;
    }



    public AutoController (AutoModel auto){
        this.auto = auto ;

    }

    @Override
    public void onClick(View v) {



        autoView.loadView();
        autoView.CargarModelo ();
        MainActivity.autoactualizado = auto ;
        ModificarAuto.modificarAuto.finish();

    }
}

