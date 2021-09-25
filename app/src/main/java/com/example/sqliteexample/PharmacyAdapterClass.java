package com.example.sqliteexample;

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

public class PharmacyAdapterClass extends RecyclerView.Adapter<PharmacyAdapterClass.ViewHolder> {

    List<PharmacyModelClass> pharmacy;
    Context context;
    database1 database12;

    public PharmacyAdapterClass(List<PharmacyModelClass> pharmacy, Context context) {
        this.pharmacy = pharmacy;
        this.context = context;
        database12 = new database1(context);
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater layoutInflater = LayoutInflater.from(parent.getContext());
        View view = layoutInflater.inflate(R.layout.pharmacy_item_list,parent,false);
        ViewHolder viewHolder = new ViewHolder(view);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull final ViewHolder holder, @SuppressLint("RecyclerView") final int position) {
        final PharmacyModelClass pharmacyModelClass = pharmacy.get(position);

        holder.textViewID.setText(Integer.toString(pharmacyModelClass.getId()));
        holder.editText_pName.setText(pharmacyModelClass.getpName());
        holder.editText_pAddress.setText(pharmacyModelClass.getpAddress());
        holder.editText_pMobile.setText(pharmacyModelClass.getpMobile());
        holder.editText_pPharmacyName.setText(pharmacyModelClass.getpPharmacyName());
        holder.editText_pPrescriptionName.setText(pharmacyModelClass.getpPrescriptionName());

        holder.button_Edit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String stringpName = holder.editText_pName.getText().toString();
                String stringpAddress = holder.editText_pAddress.getText().toString();
                String stringpMobile = holder.editText_pMobile.getText().toString();
                String stringpPharmacyName = holder.editText_pPharmacyName.getText().toString();
                String stringpPrescriptionName = holder.editText_pPrescriptionName.getText().toString();


                database12.updatePharmacy(new PharmacyModelClass(pharmacyModelClass.getId(),stringpName,stringpAddress,stringpMobile,stringpPharmacyName,stringpPrescriptionName));
                notifyDataSetChanged();
                ((Activity) context).finish();
                context.startActivity(((Activity) context).getIntent());
            }
        });

        holder.button_delete.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                database12.deletePharmacy(pharmacyModelClass.getId());
                pharmacy.remove(position);
                notifyDataSetChanged();
            }
        });

    }

    @Override
    public int getItemCount() {
        return pharmacy.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder{
        TextView textViewID;
        EditText editText_pName;
        EditText editText_pAddress;
        EditText editText_pMobile;
        EditText editText_pPharmacyName;
        EditText editText_pPrescriptionName;

        Button button_Edit;
        Button button_delete;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
//
            textViewID = itemView.findViewById(R.id.text_id);
            editText_pName = itemView.findViewById(R.id.edittext_Name);
            editText_pAddress = itemView.findViewById(R.id.edittext_Address);
            editText_pMobile = itemView.findViewById(R.id.edittext_Mobile);
            editText_pPharmacyName = itemView.findViewById(R.id.edittext_PharmacyName);
            editText_pPrescriptionName = itemView.findViewById(R.id.edittext_PrescriptionName);

            button_delete = itemView.findViewById(R.id.button_delete);
            button_Edit = itemView.findViewById(R.id.button_edit);

        }
    }
}
