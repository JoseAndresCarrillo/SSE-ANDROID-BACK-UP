package com.banzaidevelopers.ssefisi.UndergraduateShow;

import android.content.Context;
import android.content.Intent;
import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.banzaidevelopers.ssefisi.Model.FormacionAcademica;
import com.banzaidevelopers.ssefisi.R;
import com.banzaidevelopers.ssefisi.UndergraduateEdit;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Jair Barzola on 04-Jul-17.
 */

public class RecyclerAdapterFormacionAcademica extends RecyclerView.Adapter<RecyclerAdapterFormacionAcademica.ViewHolder>{

    List<FormacionAcademica> formacion_academica = new ArrayList<>();
    Context context;
    int itemLayout;

    public RecyclerAdapterFormacionAcademica(Context context, int itemLayout) {
        this.itemLayout = itemLayout;
        this.context=context;
    }
    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(itemLayout,parent,false);
        ViewHolder viewHolder= new ViewHolder(view);
        return viewHolder;
    }
    public void setListProyecto( List<FormacionAcademica> formacion_academica ) {
        this.formacion_academica = formacion_academica;
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        FormacionAcademica formacionAcademica = formacion_academica.get(position);
        holder.institucion.setText(formacionAcademica.getInstitucion());
        holder.programaAcademico.setText(formacionAcademica.getProgramaAcademico());
        holder.fecha.setText(formacionAcademica.getFechaIngreso()+" - "+formacionAcademica.getFechaEgreso());
        holder.edit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(context, UndergraduateEdit.class);
                intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                context.startActivity(intent);
            }
        });
        holder.more.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(context,"Mas información",Toast.LENGTH_SHORT).show();
            }
        });
    }

    @Override
    public int getItemCount() {
        return formacion_academica.size();
    }

    class ViewHolder extends RecyclerView.ViewHolder{
        TextView institucion;
        TextView programaAcademico;
        TextView fecha;
        public CardView cardView;
        ImageView edit;
        TextView more;

        public ViewHolder(View itemView) {
            super(itemView);
            institucion= (TextView) itemView.findViewById(R.id.institucion);
            programaAcademico= (TextView) itemView.findViewById(R.id.programa_academico);
            fecha= (TextView) itemView.findViewById(R.id.fecha);
            cardView= (CardView) itemView.findViewById(R.id.cardView);
            edit=(ImageView) itemView.findViewById(R.id.edit_formacion);
            more=(TextView) itemView.findViewById(R.id.formacionacad_more);
        }
    }
}
