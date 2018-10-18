package com.brins.facedetection;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.RectF;
import android.graphics.drawable.BitmapDrawable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.SparseArray;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.Toast;

import com.google.android.gms.vision.Frame;
import com.google.android.gms.vision.face.Face;
import com.google.android.gms.vision.face.FaceDetector;

import butterknife.BindView;
import butterknife.ButterKnife;

public class MainActivity extends AppCompatActivity {

    @BindView(R.id.iv)
     ImageView imageView;
    @BindView(R.id.but)
     Button bt1;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);
        final Bitmap mybitmap= BitmapFactory.decodeResource(getApplicationContext().getResources(),R.drawable.test);
        imageView.setImageBitmap(mybitmap);
        final Paint mypaint=new Paint();
        mypaint.setStrokeWidth(5);
        mypaint.setColor(Color.WHITE);
        mypaint.setStyle(Paint.Style.STROKE);

        final Bitmap temp=Bitmap.createBitmap(mybitmap.getWidth(),mybitmap.getHeight(),Bitmap.Config.RGB_565);
        final Canvas canvas=new Canvas(temp);
        canvas.drawBitmap(mybitmap,0,0,null);

        bt1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                FaceDetector faceDetector=new FaceDetector.Builder(getApplicationContext())
                        .setTrackingEnabled(false)
                        .setLandmarkType(FaceDetector.ALL_LANDMARKS)
                        .setMode(FaceDetector.FAST_MODE)
                        .build();
                if (!faceDetector.isOperational())
                {
                    Toast.makeText(MainActivity.this, "面部传感器不可用", Toast.LENGTH_SHORT).show();
                    return;
                }
                Frame frame=new Frame.Builder().setBitmap(mybitmap).build();
                SparseArray<Face> sparseArray=faceDetector.detect(frame);

                for (int i=0;i<sparseArray.size();i++)
                {
                    Face face=sparseArray.valueAt(i);
                    float x1=face.getPosition().x;
                    float y1=face.getPosition().y;
                    float x2=x1+face.getWidth();
                    float y2=y1+face.getHeight();
                    RectF rectF=new RectF(x1,y1,x2,y2);
                    canvas.drawRoundRect(rectF,2,2,mypaint);

                }

                imageView.setImageDrawable(new BitmapDrawable(getResources(),temp));
            }
        });

    }
}
