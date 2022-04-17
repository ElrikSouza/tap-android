package com.example.kmart.products;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.recyclerview.widget.RecyclerView;

import com.example.kmart.R;

import java.util.ArrayList;
import java.util.Locale;

public class ProductAdapter extends RecyclerView.Adapter<ProductViewHolder> {
    private Context context;
    private ArrayList<Product> allProducts;
    private ArrayList<Product> visibleProducts;
    private ProductRepository productRepository;

    public ProductAdapter(Context context) {
        this.context = context;
        this.productRepository = new ProductRepository(context);
        this.refreshList();
    }

    public void refreshList() {
        this.allProducts = productRepository.getAllProducts();
        this.visibleProducts = allProducts;
    }

    @NonNull
    @Override
    public ProductViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        ConstraintLayout layout = (ConstraintLayout) LayoutInflater.from(parent.getContext()).inflate(R.layout.product_list_item, parent, false);

        return new ProductViewHolder(layout, context);
    }

    @Override
    public void onBindViewHolder(@NonNull ProductViewHolder holder, int position) {
        Product product= visibleProducts.get(position);

        holder.productName.setText(product.getName());
        holder.description.setText(product.getDescription());
        holder.sellPrice.setText(String.format(Locale.getDefault(), "Venda R$ %.2f", product.getSellPrice()));
        holder.supplierPrice.setText(String.format(Locale.getDefault(), "Custo R$ %.2f", product.getSupplierPrice()));
        holder.quantity.setText(String.format(Locale.getDefault(), "x%d %s", product.getQuantityAvailable(), product.getMeasuringUnit()));
    }

    @Override
    public int getItemCount() {
        return visibleProducts.size();
    }
}
