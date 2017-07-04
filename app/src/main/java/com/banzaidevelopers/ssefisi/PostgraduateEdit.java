package com.banzaidevelopers.ssefisi;

import android.app.DatePickerDialog;
import android.app.Dialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.icu.text.SimpleDateFormat;
import android.os.Build;
import android.support.annotation.RequiresApi;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.Menu;
import android.view.View;
import android.view.MenuItem;
import android.widget.ArrayAdapter;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.Button;
import android.widget.Spinner;
import android.widget.Toast;

import java.util.Calendar;
import java.text.ParseException;
import java.util.Date;

public class PostgraduateEdit extends AppCompatActivity {

    PostGraduate gdtTest = new PostGraduate(3, "Universidad Nacional Mayor de San Marcos", "Pública", "Redes", "Diplomado", "2017-04-11", "2017-05-11", "2017-06-11", 120);
    private Spinner gdtInstType;
    private Spinner gdtProgrType;
    private EditText gdtInstitute;
    private EditText gdtProgram;
    private EditText gdtStartDate;
    private EditText gdtEndDate;
    private EditText gdtCertificationDate;
    private EditText gdthoraslectivas;
    protected ArrayAdapter<CharSequence> adapter;
    private int startDay;
    private int startMonth;
    private int startYear;
    private int endDay;
    private int endMonth;
    private int endYear;
    private int certDay;
    private int certMonth;
    private int certYear;
    private static final int ID_DIALOG = 0;
    private static DatePickerDialog.OnDateSetListener listenerselectordateStart;
    private static DatePickerDialog.OnDateSetListener listenerselectordateEnd;
    private static DatePickerDialog.OnDateSetListener listenerselectordateCert;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_postgraduate_edit);

        gdtInstType = (Spinner) findViewById(R.id.gdt_inst_type);
        adapter = ArrayAdapter.createFromResource(this, R.array.Institute, android.R.layout.simple_spinner_item);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        gdtInstType.setAdapter(adapter);

        gdtProgrType = (Spinner) findViewById(R.id.gdt_progr_type);
        adapter = ArrayAdapter.createFromResource(this, R.array.Programme, android.R.layout.simple_spinner_item);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        gdtProgrType.setAdapter(adapter);

        gdtInstitute = (EditText) findViewById(R.id.gdt_inst);
        gdtInstitute.setText(gdtTest.getmInstitutionName());

        gdtProgram = (EditText) findViewById(R.id.gdt_progr);
        gdtProgram.setText(gdtTest.getmProgrammeName());

        gdtStartDate = (EditText) findViewById(R.id.gdt_start_date);
        gdtStartDate.setText(gdtTest.getmStartDate());

        gdtEndDate = (EditText) findViewById(R.id.gdt_end_date);
        gdtEndDate.setText(gdtTest.getmEndDate());

        gdtCertificationDate = (EditText) findViewById(R.id.gdt_cert_date);
        gdtCertificationDate.setText(gdtTest.getmCertificationDate());

        gdthoraslectivas = (EditText) findViewById(R.id.gdt_class_hours);
        gdthoraslectivas.setText(Integer.toString(gdtTest.getMhoraslectivas()));

        gdtStartDate.setEnabled(false);
        gdtEndDate.setEnabled(false);
        gdtCertificationDate.setEnabled(false);
        captureDate();
        mostrarFecha(0);
        mostrarFecha(1);
        mostrarFecha(2);

        listenerselectordateStart = new DatePickerDialog.OnDateSetListener() {
            @Override
            public void onDateSet(DatePicker view, int year, int month, int dayOfMonth) {
                startDay = dayOfMonth;
                startMonth = month;
                startYear = year;
                mostrarFecha(0);
            }
        };

        listenerselectordateEnd = new DatePickerDialog.OnDateSetListener() {
            @Override
            public void onDateSet(DatePicker view, int year, int month, int dayOfMonth) {
                endDay = dayOfMonth;
                endMonth = month;
                endYear = year;
                mostrarFecha(1);
            }
        };

        listenerselectordateCert = new DatePickerDialog.OnDateSetListener() {
            @Override
            public void onDateSet(DatePicker view, int year, int month, int dayOfMonth) {
                certDay = dayOfMonth;
                certMonth = month;
                certYear = year;
                mostrarFecha(2);
            }
        };
        Button startDateButton = (Button) findViewById(R.id.buttonstar);
        startDateButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                showDialog(0);
            }
        });
        Button endDateButton = (Button) findViewById(R.id.buttonend);
        endDateButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                showDialog(1);
            }
        });
        Button certDateButton = (Button) findViewById(R.id.buttoncert);
        certDateButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                showDialog(2);
            }
        });
        Button deleteButton = (Button) findViewById(R.id.action_delete);
        deleteButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                deleteinformation();
            }
        });
    }

    @Override
    protected Dialog onCreateDialog(int id) {
        switch (id) {
            case 0:
                return new DatePickerDialog(this, R.style.DialogTheme, listenerselectordateStart, startYear, startMonth - 1, startDay);
            case 1:
                return new DatePickerDialog(this, R.style.DialogTheme, listenerselectordateEnd, endYear, endMonth - 1, endDay);
            case 2:
                return new DatePickerDialog(this, R.style.DialogTheme, listenerselectordateCert, certYear, certMonth - 1, certDay);
        }
        return null;
    }

    public void captureDate() {
        String starDatetochange = (gdtStartDate.getText()).toString();
        String endDatetochange = (gdtEndDate.getText()).toString();
        String certDatetochange = (gdtCertificationDate.getText()).toString();
        Calendar starDatechanged = DateConverter.convert(starDatetochange);
        Calendar endDatechanged = DateConverter.convert(endDatetochange);
        Calendar certDatechanged = DateConverter.convert(certDatetochange);

        startDay = starDatechanged.get(Calendar.DAY_OF_MONTH);
        startMonth = starDatechanged.get(Calendar.MONTH) + 1;
        startYear = starDatechanged.get(Calendar.YEAR);
        endDay = endDatechanged.get(Calendar.DAY_OF_MONTH);
        endMonth = endDatechanged.get(Calendar.MONTH) + 1;
        endYear = endDatechanged.get(Calendar.YEAR);
        certDay = certDatechanged.get(Calendar.DAY_OF_MONTH);
        certMonth = certDatechanged.get(Calendar.MONTH) + 1;
        certYear = certDatechanged.get(Calendar.YEAR);
    }

    public void mostrarFecha(int calendartype) {
        switch (calendartype) {
            case 0:
                if (startDay < 10 && startMonth < 9) {
                    gdtStartDate.setText(startYear + "-0" + (startMonth + 1) + "-0" + startDay);
                } else {
                    if (startMonth < 9) {
                        gdtStartDate.setText(startYear + "-0" + (startMonth + 1) + "-" + startDay);
                    } else if (startDay < 10)
                        gdtStartDate.setText(startYear + "-" + (startMonth + 1) + "-0" + startDay);
                    else
                        gdtStartDate.setText(startYear + "-" + (startMonth + 1) + "-" + startDay);
                }

            case 1:
                if (endDay < 10 && endMonth < 9) {
                    gdtEndDate.setText(endYear + "-0" + (endMonth + 1) + "-0" + endDay);
                } else {
                    if (endMonth < 9) {
                        gdtEndDate.setText(endYear + "-0" + (endMonth + 1) + "-" + endDay);
                    } else if (endDay < 10)
                        gdtEndDate.setText(endYear + "-" + (endMonth + 1) + "-0" + endDay);
                    else
                        gdtEndDate.setText(endYear + "-" + (endMonth + 1) + "-" + endDay);
                }


            case 2:
                if (certDay < 10 && certMonth < 9) {
                    gdtCertificationDate.setText(certYear + "-0" + (certMonth + 1) + "-0" + certDay);
                } else {
                    if (certMonth < 9) {
                        gdtCertificationDate.setText(certYear + "-0" + (certMonth + 1) + "-" + certDay);
                    } else if (certDay < 10)
                        gdtCertificationDate.setText(certYear + "-" + (certMonth + 1) + "-0" + certDay);
                    else
                        gdtCertificationDate.setText(certYear + "-" + (certMonth + 1) + "-" + certDay);
                }

        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_save, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();

        if (id == R.id.action_save) {
            validateInformation();
        }

        return super.onOptionsItemSelected(item);
    }

    private void validateInformation() {
        String institute;
        String programme;
        String startDate;
        String endDate;
        String certDate;
        String classHours;
        boolean cancel = false;

        institute = gdtInstitute.getText().toString();
        programme = gdtProgram.getText().toString();
        startDate = gdtStartDate.getText().toString();
        endDate = gdtEndDate.getText().toString();
        certDate = gdtCertificationDate.getText().toString();
        classHours = gdthoraslectivas.getText().toString();

        Calendar startDatecomp = DateConverter.convert(startDate);
        Calendar endDatecomp = DateConverter.convert(endDate);
        Calendar certDatecomp = DateConverter.convert(certDate);

        if (TextUtils.isEmpty(institute)) {
            Toast.makeText(this, "Campo de institución vacío", Toast.LENGTH_SHORT).show();
            cancel = true;
        }

        if (TextUtils.isEmpty(programme)) {
            Toast.makeText(this, "Campo de programa vacío", Toast.LENGTH_SHORT).show();
            cancel = true;
        }

        if (TextUtils.isEmpty(startDate)) {
            Toast.makeText(this, "Campo de fecha de ingreso vacío", Toast.LENGTH_SHORT).show();
            cancel = true;
        }

        if (TextUtils.isEmpty(endDate)) {
            Toast.makeText(this, "Campo de fecha de egreso vacío", Toast.LENGTH_SHORT).show();
            cancel = true;
        } else if (startDatecomp.compareTo(endDatecomp) > -1) {
            Toast.makeText(this, "Fecha de Egreso no válida. Fecha de Egreso no puede ser anterior a Fecha de Ingreso", Toast.LENGTH_SHORT).show();
            cancel = true;
        }

        if (TextUtils.isEmpty(certDate)) {
            Toast.makeText(this, "Campo de fecha de certificación vacío", Toast.LENGTH_SHORT).show();
            cancel = true;
        } else if (endDatecomp.compareTo(certDatecomp) > -1) {
            Toast.makeText(this, "Fecha de Certificación no válida. Fecha de Certifiación no puede ser anterior a Fecha de Egreso", Toast.LENGTH_SHORT).show();
            cancel = true;
        }

        if (TextUtils.isEmpty(classHours)) {
            Toast.makeText(this, "Campo de horas lectivas vacío", Toast.LENGTH_SHORT).show();
            cancel = true;
        }

        if (!cancel) {
            AlertDialog.Builder dialogo1 = new AlertDialog.Builder(this);
            dialogo1.setTitle("Importante");
            dialogo1.setMessage("¿ Confirmar cambios y guardar ?");
            dialogo1.setCancelable(false);
            dialogo1.setPositiveButton("Aceptar", new DialogInterface.OnClickListener() {
                public void onClick(DialogInterface dialogo1, int id) {
                    aceptar();
                }
            });
            dialogo1.setNegativeButton("Cancelar", new DialogInterface.OnClickListener() {
                public void onClick(DialogInterface dialogo1, int id) {
                }
            });
            dialogo1.show();
        }

    }

    public void aceptar() {
        Toast.makeText(this, getString(R.string.toast_saved), Toast.LENGTH_SHORT).show();
        Intent intent = new Intent(getApplicationContext(), PostgraduateShow.class);
        startActivity(intent);
    }

    public void cancelar() {
        finish();
    }

    public void deleteinformation() {
        AlertDialog.Builder dialogo1 = new AlertDialog.Builder(this);
        dialogo1.setTitle("Aviso");
        dialogo1.setMessage("¿ Está seguro de eliminar registro de estudios ?");
        dialogo1.setCancelable(false);
        dialogo1.setPositiveButton("Confirmar", new DialogInterface.OnClickListener() {
            public void onClick(DialogInterface dialogo1, int id) {
                aceptar();
            }
        });
        dialogo1.setNegativeButton("Cancelar", new DialogInterface.OnClickListener() {
            public void onClick(DialogInterface dialogo1, int id) {
            }
        });
        dialogo1.show();
    }
}
