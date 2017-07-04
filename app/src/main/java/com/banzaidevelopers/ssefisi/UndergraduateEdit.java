package com.banzaidevelopers.ssefisi;

import android.app.DatePickerDialog;
import android.app.Dialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.support.annotation.RequiresApi;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.text.TextUtils;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

import com.banzaidevelopers.ssefisi.Model.Undergraduate;

import java.util.Calendar;

public class UndergraduateEdit extends AppCompatActivity {
    Undergraduate gdtTest = new Undergraduate("Universidad Nacional Mayor de San Marcos", "Software", 14200180, "2017-04-11", "2017-05-11", "2017-06-11", "2017-07-11", "Ingeniero", "Tesis", "Ingenieros del perú", 120);

    private EditText gdtinst;
    private EditText gdtschool;
    private EditText gdtcod;
    private EditText gdtstart_date;
    private EditText gdtend_date;
    private EditText gdtexp1;
    private EditText gdtexp2;
    private EditText gdtrank;
    private EditText gdtmode;
    private EditText gdtprof_sch;
    private EditText gdtsch_num;
    protected ArrayAdapter<CharSequence> adapter;
    private int startDay;
    private int startMonth;
    private int startYear;
    private int endDay;
    private int endMonth;
    private int endYear;
    private int exp1Day;
    private int exp1Month;
    private int exp1Year;
    private int exp2Day;
    private int exp2Month;
    private int exp2Year;
    private Button DateButton;
    private static final int ID_DIALOG = 0;
    private static DatePickerDialog.OnDateSetListener listenerselectordateStart;
    private static DatePickerDialog.OnDateSetListener listenerselectordateEnd;
    private static DatePickerDialog.OnDateSetListener listenerselectordateExp1;
    private static DatePickerDialog.OnDateSetListener listenerselectordateExp2;

    @RequiresApi(api = Build.VERSION_CODES.N)
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_undergraduate_edit);
        Calendar starDatechanged = Calendar.getInstance();
        Calendar endDatechanged = Calendar.getInstance();
        Calendar exp1Datechanged = Calendar.getInstance();
        Calendar exp2Datechanged = Calendar.getInstance();

        String starDatetochange = gdtTest.getmStartDate();
        String endDatetochange = gdtTest.getmEndDate();
        String exp1Datetochange = gdtTest.getmExp1();
        String exp2Datetochange = gdtTest.getmExp2();
        starDatechanged = DateConverter.convert(starDatetochange);
        endDatechanged = DateConverter.convert(endDatetochange);
        exp1Datechanged = DateConverter.convert(exp1Datetochange);
        exp2Datechanged = DateConverter.convert(exp2Datetochange);

        startDay = starDatechanged.get(Calendar.DAY_OF_MONTH);
        startMonth = starDatechanged.get(Calendar.MONTH) + 1;
        startYear = starDatechanged.get(Calendar.YEAR);
        endDay = endDatechanged.get(Calendar.DAY_OF_MONTH);
        endMonth = endDatechanged.get(Calendar.MONTH) + 1;
        endYear = endDatechanged.get(Calendar.YEAR);
        exp1Day = exp1Datechanged.get(Calendar.DAY_OF_MONTH);
        exp1Month = exp1Datechanged.get(Calendar.MONTH) + 1;
        exp1Year = exp1Datechanged.get(Calendar.YEAR);
        exp2Day = exp2Datechanged.get(Calendar.DAY_OF_MONTH);
        exp2Month = exp2Datechanged.get(Calendar.MONTH) + 1;
        exp2Year = exp2Datechanged.get(Calendar.YEAR);

        System.out.println(startDay);
        System.out.println(startMonth);
        System.out.println(startYear);
        System.out.println(endDay);
        System.out.println(endMonth);
        System.out.println(endYear);
        System.out.println(exp1Day);
        System.out.println(exp1Month);
        System.out.println(exp1Year);
        System.out.println(exp2Day);
        System.out.println(exp2Month);
        System.out.println(exp2Year);


        gdtinst = (EditText) findViewById(R.id.gdt_inst);
        gdtinst.setText(gdtTest.getmInstName());

        gdtschool = (EditText) findViewById(R.id.gdt_school);
        gdtschool.setText(gdtTest.getmGdtSchool());

        gdtcod = (EditText) findViewById(R.id.gdt_cod);
        gdtcod.setText(Integer.toString(gdtTest.getmIdStudy()));

        gdtstart_date = (EditText) findViewById(R.id.gdt_start_date);
        gdtstart_date.setText(gdtTest.getmStartDate());

        gdtend_date = (EditText) findViewById(R.id.gdt_end_date);
        gdtend_date.setText(gdtTest.getmEndDate());

        gdtexp1 = (EditText) findViewById(R.id.gdt_exp1);
        gdtexp1.setText(gdtTest.getmExp1());

        gdtexp2 = (EditText) findViewById(R.id.gdt_exp2);
        gdtexp2.setText(gdtTest.getmExp2());

        gdtrank = (EditText) findViewById(R.id.gdt_rank);
        gdtrank.setText(gdtTest.getmRank());

        gdtmode = (EditText) findViewById(R.id.gdt_mode);
        gdtmode.setText(gdtTest.getmMode());

        gdtprof_sch = (EditText) findViewById(R.id.gdt_prof_sch);
        gdtprof_sch.setText(gdtTest.getmProfSch());

        gdtsch_num = (EditText) findViewById(R.id.gdt_sch_num);
        gdtsch_num.setText(Integer.toString(gdtTest.getmSchNum()));

        gdtstart_date.setEnabled(false);
        gdtend_date.setEnabled(false);
        gdtexp1.setEnabled(false);
        gdtexp2.setEnabled(false);
        captureDate();
        showDate(0);
        showDate(1);
        showDate(2);
        showDate(3);

        listenerselectordateStart = new DatePickerDialog.OnDateSetListener() {
            @Override
            public void onDateSet(DatePicker view, int year, int month, int dayOfMonth) {
                startDay = dayOfMonth;
                startMonth = month;
                startYear = year;
                showDate(0);
            }
        };

        listenerselectordateEnd = new DatePickerDialog.OnDateSetListener() {
            @Override
            public void onDateSet(DatePicker view, int year, int month, int dayOfMonth) {
                endDay = dayOfMonth;
                endMonth = month;
                endYear = year;
                showDate(1);
            }
        };

        listenerselectordateExp1 = new DatePickerDialog.OnDateSetListener() {
            @Override
            public void onDateSet(DatePicker view, int year, int month, int dayOfMonth) {
                exp1Day = dayOfMonth;
                exp1Month = month;
                exp1Year = year;
                showDate(2);
            }
        };

        listenerselectordateExp2 = new DatePickerDialog.OnDateSetListener() {
            @Override
            public void onDateSet(DatePicker view, int year, int month, int dayOfMonth) {
                exp2Day = dayOfMonth;
                exp2Month = month;
                exp2Year = year;
                showDate(3);
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

        Button exp1DateButton = (Button) findViewById(R.id.buttonexp1);
        exp1DateButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                showDialog(2);
            }
        });
        Button exp2DateButton = (Button) findViewById(R.id.buttonexp2);
        exp2DateButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                showDialog(3);
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
                return new DatePickerDialog(this, R.style.DialogTheme, listenerselectordateExp1, exp1Year, exp1Month - 1, exp1Day);
            case 3:
                return new DatePickerDialog(this, R.style.DialogTheme, listenerselectordateExp2, exp2Year, exp2Month - 1, exp2Day);
        }
        return null;
    }

    public void captureDate() {
        String starDatetochange = (gdtstart_date.getText()).toString();
        String endDatetochange = (gdtend_date.getText()).toString();
        String exp1Datetochange = (gdtexp1.getText()).toString();
        String exp2Datetochange = (gdtexp2.getText()).toString();

        Calendar starDatechanged = DateConverter.convert(starDatetochange);
        Calendar endDatechanged = DateConverter.convert(endDatetochange);
        Calendar exp1Datechanged = DateConverter.convert(exp1Datetochange);
        Calendar exp2Datechanged = DateConverter.convert(exp2Datetochange);

        startDay = starDatechanged.get(Calendar.DAY_OF_MONTH);
        startMonth = starDatechanged.get(Calendar.MONTH) + 1;
        startYear = starDatechanged.get(Calendar.YEAR);
        endDay = endDatechanged.get(Calendar.DAY_OF_MONTH);
        endMonth = endDatechanged.get(Calendar.MONTH) + 1;
        endYear = endDatechanged.get(Calendar.YEAR);
        exp1Day = exp1Datechanged.get(Calendar.DAY_OF_MONTH);
        exp1Month = exp1Datechanged.get(Calendar.MONTH) + 1;
        exp1Year = exp1Datechanged.get(Calendar.YEAR);
        exp2Day = exp2Datechanged.get(Calendar.DAY_OF_MONTH);
        exp2Month = exp2Datechanged.get(Calendar.MONTH) + 1;
        exp2Year = exp2Datechanged.get(Calendar.YEAR);
    }

    public void showDate(int calendartype) {
        switch (calendartype) {
            case 0:
                if (startDay < 10 && startMonth < 9) {
                    gdtstart_date.setText(startYear + "-0" + (startMonth + 1) + "-0" + startDay);
                } else {
                    if (startMonth < 9) {
                        gdtstart_date.setText(startYear + "-0" + (startMonth + 1) + "-" + startDay);
                    } else if (startDay < 10)
                        gdtstart_date.setText(startYear + "-" + (startMonth + 1) + "-0" + startDay);
                    else
                        gdtstart_date.setText(startYear + "-" + (startMonth + 1) + "-" + startDay);
                }

            case 1:
                if (endDay < 10 && endMonth < 9) {
                    gdtend_date.setText(endYear + "-0" + (endMonth + 1) + "-0" + endDay);
                } else {
                    if (endMonth < 9) {
                        gdtend_date.setText(endYear + "-0" + (endMonth + 1) + "-" + endDay);
                    } else if (endDay < 10)
                        gdtend_date.setText(endYear + "-" + (endMonth + 1) + "-0" + endDay);
                    else
                        gdtend_date.setText(endYear + "-" + (endMonth + 1) + "-" + endDay);
                }


            case 2:
                if (exp1Day < 10 && exp1Month < 9) {
                    gdtexp1.setText(exp1Year + "-0" + (exp1Month + 1) + "-0" + exp1Day);
                } else {
                    if (exp1Month < 9) {
                        gdtexp1.setText(exp1Year + "-0" + (exp1Month + 1) + "-" + exp1Day);
                    } else if (exp1Day < 10)
                        gdtexp1.setText(exp1Year + "-" + (exp1Month + 1) + "-0" + exp1Day);
                    else
                        gdtexp1.setText(exp1Year + "-" + (exp1Month + 1) + "-" + exp1Day);
                }

            case 3:
                if (exp2Day < 10 && exp2Month < 9) {
                    gdtexp2.setText(exp2Year + "-0" + (exp2Month + 1) + "-0" + exp2Day);
                } else {
                    if (exp2Month < 9) {
                        gdtexp2.setText(exp2Year + "-0" + (exp2Month + 1) + "-" + exp2Day);
                    } else if (exp2Day < 10)
                        gdtexp2.setText(exp2Year + "-" + (exp2Month + 1) + "-0" + exp2Day);
                    else
                        gdtexp2.setText(exp2Year + "-" + (exp2Month + 1) + "-" + exp2Day);
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
        String school;
        String startDate;
        String endDate;
        String exp1Date;
        String exp2Date;
        boolean cancel = false;

        institute = gdtinst.getText().toString();
        school = gdtschool.getText().toString();
        startDate = gdtstart_date.getText().toString();
        endDate = gdtend_date.getText().toString();
        exp1Date = gdtexp1.getText().toString();
        exp2Date = gdtexp2.getText().toString();

        Calendar startDatecomp = DateConverter.convert(startDate);
        Calendar endDatecomp = DateConverter.convert(endDate);
        Calendar exp1Datecomp = DateConverter.convert(exp1Date);
        Calendar exp2Datecomp = DateConverter.convert(exp2Date);

        if (TextUtils.isEmpty(institute)) {
            Toast.makeText(this, getString(R.string.ualert_1), Toast.LENGTH_SHORT).show();
            cancel = true;
        }

        if (TextUtils.isEmpty(school)) {
            Toast.makeText(this, getString(R.string.ualert_2), Toast.LENGTH_SHORT).show();
            cancel = true;
        }

        if (TextUtils.isEmpty(startDate)) {
            Toast.makeText(this, getString(R.string.ualert_3), Toast.LENGTH_SHORT).show();
            cancel = true;
        }

        if (TextUtils.isEmpty(endDate)) {
            Toast.makeText(this, getString(R.string.ualert_4), Toast.LENGTH_SHORT).show();
            cancel = true;
        } else if (startDatecomp.compareTo(endDatecomp) > -1) {
            Toast.makeText(this, getString(R.string.udate_error1), Toast.LENGTH_SHORT).show();
            cancel = true;
        }


        if (TextUtils.isEmpty(exp1Date)) {
            Toast.makeText(this, getString(R.string.ualert_6a), Toast.LENGTH_SHORT).show();
            cancel = true;
        } else if (endDatecomp.compareTo(exp1Datecomp) > -1) {
            Toast.makeText(this, getString(R.string.ualert_6b), Toast.LENGTH_SHORT).show();
            cancel = true;
        }

        if (TextUtils.isEmpty(exp2Date)) {
            Toast.makeText(this, getString(R.string.ualert_7a), Toast.LENGTH_SHORT).show();
            cancel = true;
        } else if (endDatecomp.compareTo(exp2Datecomp) > -1) {
            Toast.makeText(this, getString(R.string.ualert_7b), Toast.LENGTH_SHORT).show();
            cancel = true;
        }


        if (!cancel) {
            AlertDialog.Builder dialogo1 = new AlertDialog.Builder(this);
            dialogo1.setTitle(getString(R.string.uimportant));
            dialogo1.setMessage(getString(R.string.uquestion1));
            dialogo1.setCancelable(false);
            dialogo1.setPositiveButton(getString(R.string.uaccept), new DialogInterface.OnClickListener() {
                public void onClick(DialogInterface dialogo1, int id) {
                    accept();
                }
            });
            dialogo1.setNegativeButton(getString(R.string.ucancel), new DialogInterface.OnClickListener() {
                public void onClick(DialogInterface dialogo1, int id) {
                }
            });
            dialogo1.show();
        }


    }

    public void accept() {
        Toast.makeText(this, getString(R.string.toast_saved), Toast.LENGTH_SHORT).show();
        Intent intent = new Intent(getApplicationContext(), UndergraduateShow.class);
        startActivity(intent);
    }

    public void cancelar() {
        finish();
    }

    public void deleteinformation() {
        AlertDialog.Builder dialogo1 = new AlertDialog.Builder(this);
        dialogo1.setTitle(getString(R.string.ualert_5));
        dialogo1.setMessage(getString(R.string.uquestion2));
        dialogo1.setCancelable(false);
        dialogo1.setPositiveButton(getString(R.string.uconfirm), new DialogInterface.OnClickListener() {
            public void onClick(DialogInterface dialogo1, int id) {
                accept();
            }
        });
        dialogo1.setNegativeButton(getString(R.string.ucancel), new DialogInterface.OnClickListener() {
            public void onClick(DialogInterface dialogo1, int id) {
            }
        });
        dialogo1.show();
    }
}

