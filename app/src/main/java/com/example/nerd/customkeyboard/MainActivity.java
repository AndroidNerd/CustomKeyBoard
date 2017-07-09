package com.example.nerd.customkeyboard;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.Editable;
import android.text.InputType;
import android.view.View;
import android.view.WindowManager;
import android.widget.EditText;
import android.widget.TextView;

import java.lang.reflect.Method;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    private EditText editText;
    private TextView tv_one, tv_two, tv_three, tv_four, tv_five, tv_six, tv_seven, tv_eight, tv_nine, tv_zero, tv_del;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        editText = (EditText) findViewById(R.id.edit);
        tv_one = (TextView) findViewById(R.id.tv_one);
        tv_two = (TextView) findViewById(R.id.tv_two);
        tv_three = (TextView) findViewById(R.id.tv_three);
        tv_four = (TextView) findViewById(R.id.tv_four);
        tv_five = (TextView) findViewById(R.id.tv_five);
        tv_six = (TextView) findViewById(R.id.tv_six);
        tv_seven = (TextView) findViewById(R.id.tv_seven);
        tv_eight = (TextView) findViewById(R.id.tv_eight);
        tv_nine = (TextView) findViewById(R.id.tv_nine);
        tv_zero = (TextView) findViewById(R.id.tv_zero);
        tv_del = (TextView) findViewById(R.id.tv_del);
        tv_one.setOnClickListener(this);
        tv_two.setOnClickListener(this);
        tv_three.setOnClickListener(this);
        tv_four.setOnClickListener(this);
        tv_five.setOnClickListener(this);
        tv_six.setOnClickListener(this);
        tv_seven.setOnClickListener(this);
        tv_eight.setOnClickListener(this);
        tv_nine.setOnClickListener(this);
        tv_zero.setOnClickListener(this);
        tv_del.setOnClickListener(this);


        if (android.os.Build.VERSION.SDK_INT <= 10) {
            editText.setInputType(InputType.TYPE_NULL);
        } else {
            getWindow().setSoftInputMode(
                    WindowManager.LayoutParams.SOFT_INPUT_STATE_ALWAYS_HIDDEN);
            try {
                Class<EditText> cls = EditText.class;
                Method setShowSoftInputOnFocus;
                setShowSoftInputOnFocus = cls.getMethod(
                        "setShowSoftInputOnFocus", boolean.class);
                setShowSoftInputOnFocus.setAccessible(true);
                setShowSoftInputOnFocus.invoke(editText, false);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    @Override
    public void onClick(View view) {
        int start;
        Editable editable = editText.getText();
        switch (view.getId()) {
            case R.id.tv_one:
                deleteSelect(editText);
                start = editText.getSelectionStart();
                editable.insert(start, "1");
                break;
            case R.id.tv_two:
                deleteSelect(editText);
                start = editText.getSelectionStart();
                editable.insert(start, "2");
                break;
            case R.id.tv_three:
                deleteSelect(editText);
                start = editText.getSelectionStart();
                editable.insert(start, "3");
                break;
            case R.id.tv_four:
                deleteSelect(editText);
                start = editText.getSelectionStart();
                editable.insert(start, "4");
                break;
            case R.id.tv_five:
                deleteSelect(editText);
                start = editText.getSelectionStart();
                editable.insert(start, "5");
                break;
            case R.id.tv_six:
                deleteSelect(editText);
                start = editText.getSelectionStart();
                editable.insert(start, "6");
                break;
            case R.id.tv_seven:
                deleteSelect(editText);
                start = editText.getSelectionStart();
                editable.insert(start, "7");
                break;
            case R.id.tv_eight:
                deleteSelect(editText);
                start = editText.getSelectionStart();
                editable.insert(start, "8");
                break;
            case R.id.tv_nine:
                deleteSelect(editText);
                start = editText.getSelectionStart();
                editable.insert(start, "9");
                break;
            case R.id.tv_zero:
                deleteSelect(editText);
                start = editText.getSelectionStart();
                editable.insert(start, "0");
                break;
            case R.id.tv_del:
                start = editText.getSelectionStart();
                int end = editText.getSelectionEnd();
                editable = editText.getText();
                if (start != end) {
                    if (start > end) {
                        int temp = start;
                        start = end;
                        end = temp;
                    }
                    editable.delete(start, end);
                } else if (start > 0)
                    editable.delete(start - 1, start);


        }
    }

    public void deleteSelect(EditText editText) {
        int start = editText.getSelectionStart();
        int end = editText.getSelectionEnd();
        Editable editable = editText.getText();
        if (start != end) {
            if (start > end) {
                int temp = start;
                start = end;
                end = temp;
            }
            editable.delete(start, end);
        }
    }

}
