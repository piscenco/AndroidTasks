package com.example.fragmentsample;
/*
import android.Manifest;
import android.content.pm.PackageManager;
import android.os.AsyncTask;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import java.io.File;
import java.util.UUID;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.camera.core.ImageCapture;
import androidx.camera.core.ImageCaptureException;
import androidx.camera.view.CameraController;
import androidx.camera.view.LifecycleCameraController;
import androidx.camera.view.PreviewView;
import androidx.core.app.ActivityCompat;
import androidx.core.content.ContextCompat;
import androidx.fragment.app.Fragment;
/*
public class CameraFragment extends Fragment implements ImageCapture.OnImageSavedCallback {
    private static final int CAMERA_REQUEST_CODE = 0;

    private LifecycleCameraController cameraController;
    private PreviewView cameraView;
    private View takePictureButton;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup parent, Bundle savedInstanceState)
    { // параметры или поля? что передавать?


        return inflater.inflate(R.layout.fragment_list, parent, true);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        if( ContextCompat.checkSelfPermission( getContext(), Manifest.permission.CAMERA )
                == PackageManager.PERMISSION_GRANTED ) {
            startCamera();
        } else {
            requestPermission();
        }
    }

    private void requestPermission()
    {
        ActivityCompat.requestPermissions(
                getActivity(),
                new String[] { Manifest.permission.CAMERA },
                CAMERA_REQUEST_CODE
        );
    }



    private void startCamera()
    {
        cameraController = new LifecycleCameraController( getActivity() );
        cameraController.bindToLifecycle( this );
        cameraController.setEnabledUseCases( CameraController.IMAGE_CAPTURE );
        cameraView = getView().findViewById( R.id.cameraView );
        cameraView.setController( cameraController );

        takePictureButton = getView().findViewById( R.id.takePictureButton );
        takePictureButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                ImageCapture.OutputFileOptions options = new ImageCapture.OutputFileOptions.Builder( generatePictureFile() ).build();
                cameraController.takePicture(
                        options,
                        AsyncTask.SERIAL_EXECUTOR,
                        CameraFragment.this
                );
            }

        } );
    }

    private File generatePictureFile()
    {
        return new File( getContext().getFilesDir(), UUID.randomUUID().toString() );//что это за функция?
    }

    @Override
    public void onImageSaved( @NonNull ImageCapture.OutputFileResults outputFileResults )
    {

    }

    @Override
    public void onError( @NonNull ImageCaptureException exception )
    {
        getActivity().finish();
    }


}*/
