import customtkinter as ctk
from tkinter import Listbox, messagebox

class CategoryView(ctk.CTkToplevel):
    def __init__(self, parent, category_name, products, controller):
        super().__init__(parent)
        self.title(f"🛍 {category_name}")
        self.geometry("500x500")
        self.controller = controller
        self.products = products

        label = ctk.CTkLabel(self, text=f"📦 {category_name}", font=("Arial", 18, "bold"))
        label.pack(pady=10)

        self.listbox = Listbox(self, width=40, height=15, font=("Arial", 12))
        self.listbox.pack(pady=10)

        for product in self.products:
            self.listbox.insert("end", product.display_info())  # Call polymorphic method

        add_button = ctk.CTkButton(self, text="➕ Add to Cart", command=self.add_to_cart)
        add_button.pack(pady=5)

        back_button = ctk.CTkButton(self, text="⬅ Back", command=self.destroy)
        back_button.pack(pady=5)

    def add_to_cart(self):
        selected_idx = self.listbox.curselection()
        if not selected_idx:
            messagebox.showwarning("⚠ Warning", "Please select a product.")
            return

        selected_product = self.products[selected_idx[0]]
        self.controller.user.shopping_cart.add_to_cart(selected_product, 1)
        messagebox.showinfo("✅ Success", f"{selected_product.name} added to cart!")
