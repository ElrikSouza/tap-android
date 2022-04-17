package com.example.kmart.products;

import android.content.Context;
import android.widget.TextView;

import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.recyclerview.widget.RecyclerView;

import com.example.kmart.R;

public class ProductViewHolder extends RecyclerView.ViewHolder {
    public Context context;
    public TextView productName, description, sellPrice, supplierPrice, quantity;

    public ProductViewHolder(ConstraintLayout layout, Context context) {
        super(layout);
        this.context = context;

        this.productName = layout.findViewById(R.id.product_name);
        this.description = layout.findViewById(R.id.product_description);
        this.sellPrice = layout.findViewById(R.id.product_sell_price);
        this.supplierPrice = layout.findViewById(R.id.product_supplier_price);
        this.quantity = layout.findViewById(R.id.product_quantity);
    }
}
