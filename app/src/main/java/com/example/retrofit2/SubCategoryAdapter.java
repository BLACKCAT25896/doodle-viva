package com.example.retrofit2;

import android.content.Context;
import android.content.SharedPreferences;
import android.preference.PreferenceManager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class SubCategoryAdapter extends RecyclerView.Adapter<SubCategoryAdapter.ViewHolder> {


    private Context context;
    private List<Subcatg> subcatgList;
    private boolean isPlay;

    public static final  String value = "key";

    public SubCategoryAdapter(List<Subcatg> subcatgList) {
        this.subcatgList = subcatgList;
    }

    public SubCategoryAdapter(Context context) {
        this.context = context;
    }

//    SharedPreferences pref = context.getApplicationContext().getSharedPreferences("MyPref", 0); // 0 - for private mode
//    private boolean isPlay = context.getApplicationContext().getSharedPreferences("MyPref", 0).getBoolean("is_added", false);

//    SharedPreferences preferences = context.getSharedPreferences("MyPref", context.MODE_PRIVATE);
//    boolean isPlay = preferences.getBoolean(value,true);



    @NonNull
    @Override
    public SubCategoryAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.subcategory_item_layout,parent,false);
        return new SubCategoryAdapter.ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull SubCategoryAdapter.ViewHolder holder, int position) {
        Subcatg subcatg = subcatgList.get(position);
        holder.subCategoryTitle.setText(subcatg.getSub_category_name());

        holder.subCatAddBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if(isPlay){
//                    count+=1;
                    v.setBackgroundResource(R.drawable.ic_baseline_check_24);
//                    isPlay = false;
                }else{
//                    count-=1;
                    v.setBackgroundResource(R.drawable.ic_baseline_add_24);
//                    isPlay = true;
                }

                isPlay = !isPlay; //
//                Toast.makeText(context, String.valueOf(count), Toast.LENGTH_SHORT).show();

            }
        });

    }

    @Override
    public int getItemCount() {
        return subcatgList.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        private TextView subCategoryTitle;
        private ImageButton subCatAddBtn;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);

            subCategoryTitle = itemView.findViewById(R.id.subCategoryTitle);
            subCatAddBtn = itemView.findViewById(R.id.subCategoryAddBtn);
        }
    }
}
