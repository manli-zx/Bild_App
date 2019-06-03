package com.vanja1942ns.bildapp;

import android.content.Intent;
import android.graphics.Bitmap;
import android.net.Uri;
import android.provider.MediaStore;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import org.w3c.dom.Text;

public class Book_Activity extends AppCompatActivity {

    private TextView tvtitle, tvdescription, tvcategory;
    private ImageView img;
    ImageView mImageView;
    Button mButton;
    Button mButton2;
    private static final int PICK_IMAGE = 100;
    private static final int CAMERA_REQUEST = 200;
    Uri imageUrl;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_book_);


        tvtitle = findViewById(R.id.txtTitles);
        tvdescription = findViewById(R.id.txtDesc);
        img = findViewById(R.id.bookthumbnail);


        mImageView = findViewById(R.id.photo);
        mButton = findViewById(R.id.välj_bild);
        mButton2 = findViewById(R.id.ta_bild);

        mButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openGallery();
            }
        });

        mButton2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openCamera();
            }
        });



    //Recieve data
    Intent intent = getIntent();




    String Title = intent.getExtras().getString("BookTitle");
    String Description = intent.getExtras().getString("Description");
    int image = intent.getExtras().getInt("Thumbnail");

    //Setting values

        tvtitle.setText(Title);
        tvdescription.setText(Description);
        img.setImageResource(image);
}

    private void openGallery() {
        Intent gallery = new Intent(Intent.ACTION_PICK, MediaStore.Images.Media.INTERNAL_CONTENT_URI);
        startActivityForResult(gallery, PICK_IMAGE);
    }

    private void openCamera(){
        Intent intent = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
        startActivityForResult(intent,CAMERA_REQUEST);
        }




    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (resultCode == RESULT_OK && requestCode == PICK_IMAGE) {
            imageUrl = data.getData();
            mImageView.setImageURI(imageUrl);
        }


      if(requestCode ==CAMERA_REQUEST && resultCode == RESULT_OK ){
          Bundle extras = data.getExtras();
          Bitmap image =(Bitmap)extras.get("data");
          mImageView.setImageBitmap(image);

      }
    }
}


