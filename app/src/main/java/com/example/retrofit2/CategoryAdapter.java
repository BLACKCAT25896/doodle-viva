package com.example.retrofit2;

import android.content.Context;
import android.content.SharedPreferences;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class CategoryAdapter extends RecyclerView.Adapter<CategoryAdapter.ViewHolder> {

    private RecyclerView.RecycledViewPool viewPool = new RecyclerView.RecycledViewPool();



    private Context context;
    private List<Category> categories;

    private boolean hide=true;
    private boolean isPlay=false;

    public CategoryAdapter(Context context, List<Category> categories) {
        this.context = context;
        this.categories = categories;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.category_item_design,parent,false);
        return new CategoryAdapter.ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        Category category = categories.get(position);
        holder.categoryTitle.setText(category.getCategory_name());

        LinearLayoutManager layoutManager = new LinearLayoutManager(holder.subRecyclerVew.getContext(),LinearLayoutManager.VERTICAL,false);

        layoutManager.setInitialPrefetchItemCount(category.getSubcatg().size());

        SubCategoryAdapter subCategoryAdapter = new SubCategoryAdapter(category.getSubcatg());
                holder.subRecyclerVew.setLayoutManager(layoutManager);
                holder.subRecyclerVew.setAdapter(subCategoryAdapter);
                holder.subRecyclerVew.setRecycledViewPool(viewPool);



        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if (hide){
                    holder.subRecyclerVew.setVisibility(View.VISIBLE);
                    hide=false;

                }else {
                    holder.subRecyclerVew.setVisibility(View.GONE);
                    hide=true;

                }
            }
        });
        holder.addBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if(isPlay){
                    v.setBackgroundResource(R.drawable.ic_baseline_check_24);
                }else{
                    v.setBackgroundResource(R.drawable.ic_baseline_add_24);
                }

                isPlay = !isPlay; //

            }
        });

    }

    @Override
    public int getItemCount() {
        return categories.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        private TextView categoryTitle;
        private ImageButton addBtn;
        private RecyclerView subRecyclerVew;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            categoryTitle = itemView.findViewById(R.id.categoryTitle);
            addBtn = itemView.findViewById(R.id.categoryAddBtn);
            subRecyclerVew = itemView.findViewById(R.id.subCatRecycler);
        }
    }
}
