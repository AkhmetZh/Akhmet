import customtkinter as ctk
from tkinter import messagebox

class CartView(ctk.CTkToplevel):
    def __init__(self, parent, controller):
        super().__init__(parent)
        self.controller = controller
        self.title("🛒 Your Cart")
        self.geometry("500x500")

        self.textbox = ctk.CTkTextbox(self, width=400, height=250)
        self.textbox.pack(pady=10)

        for item in self.controller.get_cart_items():
            product = item[0]
            self.textbox.insert("end", f"{product.name} - ${product.price} x{item[1]}\n")

        remove_button = ctk.CTkButton(self, text="❌ Remove", command=self.remove_from_cart)
        remove_button.pack(pady=5)

        pay_button = ctk.CTkButton(self, text="💳 Payment", command=self.process_payment)
        pay_button.pack(pady=5)

        back_button = ctk.CTkButton(self, text="⬅ Back", command=self.go_back)
        back_button.pack(pady=5)

    def remove_from_cart(self):
        selected_text = self.textbox.get("1.0", "end-1c").strip()
        if selected_text:
            product_name = selected_text.split(' - ')[0]
            self.controller.remove_from_cart(product_name)
            self.textbox.delete("1.0", "end-1c")
            self.update_cart_display()

    def process_payment(self):
        message = self.controller.process_payment()
        messagebox.showinfo("Payment", message)

    def update_cart_display(self):
        self.textbox.delete("1.0", "end")
        for item in self.controller.get_cart_items():
            product = item[0]
            self.textbox.insert("end", f"{product.name} - ${product.price} x{item[1]}\n")

    def go_back(self):
        self.destroy()
