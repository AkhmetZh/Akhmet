import customtkinter as ctk
from tkinter import messagebox

class SpecialOrder(ctk.CTkToplevel):
    def __init__(self, parent, controller):
        super().__init__(parent)
        self.title("⭐ Special Order")
        self.geometry("400x300")
        self.controller = controller

        self.label = ctk.CTkLabel(self, text="Enter details for your special order:", font=("Arial", 14, "bold"))
        self.label.pack(pady=10)

        self.name_entry = ctk.CTkEntry(self, placeholder_text="Product Name")
        self.name_entry.pack(pady=5)

        self.quantity_entry = ctk.CTkEntry(self, placeholder_text="Quantity")
        self.quantity_entry.pack(pady=5)

        self.comment_entry = ctk.CTkEntry(self, placeholder_text="Additional Comments")
        self.comment_entry.pack(pady=5)

        submit_btn = ctk.CTkButton(self, text="📩 Submit Order", command=self.submit_order)
        submit_btn.pack(pady=10)

    def submit_order(self):
        product_name = self.name_entry.get()
        quantity = self.quantity_entry.get()
        comments = self.comment_entry.get()

        if not product_name or not quantity.isdigit():
            messagebox.showwarning("⚠ Warning", "Please enter a valid product name and quantity.")
            return

        messagebox.showinfo("✅ Order Placed", f"Special order placed for {quantity} x {product_name}.\nComments: {comments}")
        self.destroy()
