package com.example.kmart.inventory;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.ViewGroup;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.recyclerview.widget.RecyclerView;

import com.example.kmart.R;
import com.example.kmart.products.Product;

import java.util.ArrayList;
import java.util.Locale;
import java.util.function.Consumer;

public class ShoppingCartAdapter  extends RecyclerView.Adapter<ShoppingCartRowViewHolder> {
    private final Consumer<String> onRemoveProductFromCart;
    private ArrayList<SaleEntry> products;
    private final Context context;

    public ShoppingCartAdapter(Context context, Consumer<String> onRemoveProductFromCart) {
        this.onRemoveProductFromCart = onRemoveProductFromCart;
        this.context = context;
        this.products = new ArrayList<SaleEntry>();
    }

    public void setProductList(ArrayList<SaleEntry> newProductList)  {
        this.products = newProductList;
    }

    @NonNull
    @Override
    public ShoppingCartRowViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        ConstraintLayout layout = (ConstraintLayout) LayoutInflater.from(parent.getContext()).inflate(R.layout.shopping_cart_row_layout, parent, false);

        return new ShoppingCartRowViewHolder(layout, context);
    }

    @Override
    public void onBindViewHolder(@NonNull ShoppingCartRowViewHolder holder, int position) {
        SaleEntry saleEntry = products.get(position);
        Product product = saleEntry.getProduct();
        int quantity = saleEntry.getQuantity();

        holder.productName.setText(product.getName());
        String quantityAndPriceText = String.format(Locale.getDefault(), "(x%d %s) %.2f R$", quantity, product.getMeasuringUnit(), product.getSellPrice());
        holder.productQuantityAndPrice.setText(quantityAndPriceText);
        holder.removeFromCartButton.setOnClickListener(it -> this.onRemoveProductFromCart.accept(product.getBarcode()));
    }

    @Override
    public int getItemCount() {
        return products.size();
    }
}
