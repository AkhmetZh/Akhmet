import customtkinter as ctk
import views.category_view
import views.cart_view
import views.special_order

class MainView(ctk.CTk):
    def __init__(self, controller):
        super().__init__()
        self.controller = controller
        self.title("🛒 Shopping Cart System")
        self.geometry("600x600")

        self.label = ctk.CTkLabel(self, text="📖 Choose a Category", font=("Arial", 18, "bold"))
        self.label.pack(pady=20)

        self.categories = ["Electronics", "Clothing", "Food"]
        for category in self.categories:
            btn = ctk.CTkButton(self, text=category, command=lambda c=category: self.open_category(c))
            btn.pack(pady=5)

        cart_btn = ctk.CTkButton(self, text="🛒 View Cart", command=self.view_cart)
        cart_btn.pack(pady=5)

        special_btn = ctk.CTkButton(self, text="⭐ Special Order", command=self.special_order)
        special_btn.pack(pady=5)

    def open_category(self, category):
        products = self.controller.get_products_for_category(category)
        from shopping_cart_system.views.category_view import CategoryView
        CategoryView(self, category, products, self.controller)

    def view_cart(self):
        cart_window = ctk.CTkToplevel(self)
        from shopping_cart_system.views.cart_view import CartView
        CartView(cart_window, self.controller)

    def special_order(self):
        order_window = ctk.CTkToplevel(self)
        from shopping_cart_system.views.special_order import SpecialOrder
        SpecialOrder(order_window, self.controller)
