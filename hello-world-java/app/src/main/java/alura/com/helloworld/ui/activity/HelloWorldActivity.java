package alura.com.helloworld.ui.activity;

import android.os.Bundle;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import alura.com.helloworld.R;

public class HelloWorldActivity extends AppCompatActivity {

    public static final String TITULO_APPBAR = "Hello World";

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_hello_world);
        setTitle(TITULO_APPBAR);
    }
}
