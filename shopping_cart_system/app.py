from shopping_cart.user import User
from controllers.shopping_controller import ShoppingController
from views.main_view import MainView

if __name__ == "__main__":
    user = User("Akhmet")
    controller = ShoppingController()
    app = MainView(controller)
    app.mainloop()
