package com.example.kmart.inventory;

import android.content.Context;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.TextView;

import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.recyclerview.widget.RecyclerView;

import com.example.kmart.R;

public class ShoppingCartRowViewHolder extends RecyclerView.ViewHolder {
    public Context context;
    public TextView productName, productQuantityAndPrice;
    public ImageButton removeFromCartButton;

    public ShoppingCartRowViewHolder(ConstraintLayout layout, Context context) {
        super(layout);
        this.context = context;

        this.productName = layout.findViewById(R.id.cart_product_name);
        this.productQuantityAndPrice = layout.findViewById(R.id.cart_product_quantity_price);
        this.removeFromCartButton = layout.findViewById(R.id.remove_from_cart_btn);
    }
}
