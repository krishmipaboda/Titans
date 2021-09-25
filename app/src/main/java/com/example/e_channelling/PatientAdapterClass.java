package com.example.e_channelling;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class PatientAdapterClass extends RecyclerView.Adapter<PatientAdapterClass.ViewHolder> {

    List<PatientModelClass> patient;
    Context context;
    DatabaseHelpClass databaseHelpClass;

    public PatientAdapterClass(List<PatientModelClass> patient, Context context) {
        this.patient = patient;
        this.context = context;
        databaseHelpClass = new DatabaseHelpClass(context);
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater layoutInflater = LayoutInflater.from(parent.getContext());
        View view = layoutInflater.inflate(R.layout.patient_item_list,parent,false);
        ViewHolder viewHolder = new ViewHolder(view);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull final ViewHolder holder, @SuppressLint("RecyclerView") final int position) {
        final PatientModelClass patientModelClass = patient.get(position);

        holder.textViewNIC.setText(Integer.toString(patientModelClass.getNic()));
        holder.editText_Firstname.setText(patientModelClass.getFirstname());
        holder.editText_Lastname.setText(patientModelClass.getLastname());
        holder.editText_Email.setText(patientModelClass.getEmail());
        holder.editText_Contact.setText(patientModelClass.getContact());
        holder.editText_Age.setText(patientModelClass.getAge());


        holder.button_Edit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String stringFirstname = holder.editText_Firstname.getText().toString();
                String stringLastname = holder.editText_Lastname.getText().toString();
                String stringEmail = holder.editText_Email.getText().toString();
                String stringContact = holder.editText_Contact.getText().toString();
                String stringAge = holder.editText_Age.getText().toString();


                databaseHelpClass.updatePatient(new PatientModelClass(patientModelClass.getNic(),stringFirstname,stringLastname,stringEmail,stringContact,stringAge));
                notifyDataSetChanged();
                ((Activity) context).finish();
                context.startActivity(((Activity) context).getIntent());
            }
        });

        holder.button_delete.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                databaseHelpClass.deletePatient(patientModelClass.getNic());
                patient.remove(position);
                notifyDataSetChanged();
            }
        });

    }

    @Override
    public int getItemCount() {
        return patient.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder{
        TextView textViewNIC;
        EditText editText_Firstname;
        EditText editText_Lastname;
        EditText editText_Email;
        EditText editText_Contact;
        EditText editText_Age;

        Button button_Edit;
        Button button_delete;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);

            textViewNIC = itemView.findViewById(R.id.text_nic);
            editText_Firstname = itemView.findViewById(R.id.edittext_firstname);
            editText_Lastname = itemView.findViewById(R.id.edittext_lastname);
            editText_Email = itemView.findViewById(R.id.edittext_email);
            editText_Contact = itemView.findViewById(R.id.edittext_contact);
            editText_Age= itemView.findViewById(R.id.edittext_age);


            button_delete = itemView.findViewById(R.id.button_delete);
            button_Edit = itemView.findViewById(R.id.button_edit);

        }
    }
}
