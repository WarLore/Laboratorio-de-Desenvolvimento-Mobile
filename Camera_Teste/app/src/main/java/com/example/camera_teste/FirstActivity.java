package com.example.camera_teste;

import android.app.Activity;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.content.Intent;
import android.provider.MediaStore;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

public class FirstActivity extends Activity {

    static final int REQUEST_IMAGE_CAPTURE = 1;
    @Override
    public void onCreate(Bundle save){
        super.onCreate(save);
        setContentView(R.layout.activity_principal);

        Button btn_abrirCamera = (Button) findViewById(R.id.btn_abrirCamera);
        btn_abrirCamera.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                Intent tirarFoto = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
                startActivityForResult(tirarFoto, REQUEST_IMAGE_CAPTURE);
            }
        });
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        if (requestCode == REQUEST_IMAGE_CAPTURE && resultCode == RESULT_OK) {
            Bundle extras = data.getExtras();
            Bitmap imageBitmap = (Bitmap) extras.get("data");

            ImageView foto = (ImageView) findViewById(R.id.imgview_foto);
            foto.setImageBitmap(imageBitmap);
        }
    }
}
