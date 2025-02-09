from shopping_cart_system.shopping_cart.models import Electronics, Clothing, Food
from shopping_cart_system.shopping_cart.user import User
from shopping_cart_system.shopping_cart.shopping_cart import ShoppingCart

class ShoppingController:
    def __init__(self):
        self.user = User("Akhmet Zhaksybay")
        self.products = {
            "Electronics": [
                Electronics("💻 Laptop", 1200, 10, 2),
                Electronics("📱 Smartphone", 800, 15, 1),
                Electronics("🎧 Headphones", 150, 50, 3),
                Electronics("⌚ Smartwatch", 250, 25, 2),
                Electronics("🔊 Bluetooth Speaker", 80, 40, 1),
                Electronics("📟 Tablet", 350, 20, 2),
                Electronics("🎮 Gaming Console", 400, 10, 5),
                Electronics("📷 Camera", 500, 15, 4),
                Electronics("🖥️ Monitor", 300, 20, 2),
                Electronics("⌨️ Mechanical Keyboard", 120, 30, 3),
                Electronics("🖱️ Gaming Mouse", 60, 40, 2),
                Electronics("🖨️ Printer", 250, 10, 2),
                Electronics("📀 External Hard Drive", 100, 25, 5),
                Electronics("🎙️ Microphone", 180, 15, 3),
                Electronics("📡 WiFi Router", 90, 30, 2),
                Electronics("🎥 Video Camera", 700, 8, 4),
                Electronics("🔋 Power Bank", 50, 60, 1),
                Electronics("💾 USB Flash Drive", 25, 100, 2),
                Electronics("📺 Smart TV", 1000, 12, 5),
                Electronics("🎛️ DJ Mixer", 450, 5, 4),
                Electronics("🎚️ Audio Interface", 220, 8, 3),
                Electronics("🔦 LED Flashlight", 30, 50, 1),
                Electronics("📡 GPS Navigator", 130, 10, 3),
            ],
            "Clothing": [
                Clothing("👕 T-Shirt", 20, 50, "M"),
                Clothing("👖 Jeans", 40, 30, "L"),
                Clothing("🧥 Sweater", 35, 40, "S"),
                Clothing("🧥 Jacket", 60, 15, "XL"),
                Clothing("👟 Sneakers", 70, 60, "42"),
                Clothing("👗 Dress", 50, 25, "M"),
                Clothing("🩳 Shorts", 30, 50, "L"),
                Clothing("🧣 Scarf", 15, 70, "One Size"),
                Clothing("🧤 Gloves", 18, 50, "M"),
                Clothing("🧢 Cap", 25, 40, "One Size"),
                Clothing("🎩 Hat", 30, 20, "M"),
                Clothing("🦺 Vest", 45, 20, "L"),
                Clothing("👔 Shirt", 35, 30, "M"),
                Clothing("🩲 Underwear", 15, 100, "L"),
                Clothing("🧦 Socks", 10, 120, "One Size"),
                Clothing("👞 Formal Shoes", 90, 25, "43"),
                Clothing("🩱 Swimsuit", 45, 30, "M"),
                Clothing("👖 Cargo Pants", 50, 20, "XL"),
                Clothing("🧥 Trench Coat", 120, 10, "L"),
                Clothing("👘 Kimono", 80, 5, "One Size"),
                Clothing("🦶 Slippers", 25, 50, "41"),
                Clothing("🥋 Sportswear", 65, 30, "M"),
                Clothing("👑 Beanie", 20, 40, "One Size"),
                Clothing("👚 Blouse", 45, 35, "S"),
            ],
            "Food": [
                Food("🍏 Apple", 1, 100, "2025-01-01"),
                Food("🥛 Milk", 2.5, 20, "2024-02-15"),
                Food("🍌 Banana", 0.5, 120, "2025-03-01"),
                Food("🍊 Orange Juice", 3, 30, "2024-02-10"),
                Food("🥚 Eggs", 3, 50, "2024-02-20"),
                Food("🍞 Bread", 1.8, 80, "2024-02-07"),
                Food("🧀 Cheese", 5, 40, "2024-03-01"),
                Food("🥣 Yogurt", 2, 100, "2024-02-28"),
                Food("🍅 Tomatoes", 2, 70, "2025-01-10"),
                Food("🥕 Carrots", 1.2, 90, "2025-01-15"),
                Food("🥩 Beef", 15, 30, "2024-02-25"),
                Food("🍗 Chicken", 12, 50, "2024-02-22"),
                Food("🐟 Salmon", 18, 25, "2024-02-28"),
                Food("🍚 Rice", 3, 100, "2025-06-01"),
                Food("🍝 Pasta", 2.5, 90, "2025-05-10"),
                Food("🍫 Chocolate", 4, 60, "2025-04-15"),
                Food("🍪 Cookies", 3.5, 70, "2025-03-20"),
                Food("🍯 Honey", 8, 40, "2026-01-01"),
                Food("🥜 Peanuts", 6, 50, "2025-09-10"),
                Food("🥗 Salad Mix", 4, 30, "2024-02-12"),
                Food("🍍 Pineapple", 5, 20, "2025-02-01"),
                Food("🥭 Mango", 4.5, 25, "2025-03-05"),
                Food("🍉 Watermelon", 7, 15, "2025-04-01"),
                Food("🥤 Soda", 2, 80, "2025-06-01"),
                Food("🍷 Wine", 25, 10, "2030-01-01"),
                Food("☕ Coffee", 10, 50, "2026-01-01"),
                Food("🍵 Green Tea", 8, 60, "2026-06-01"),
                Food("🧃 Fruit Juice", 3.5, 40, "2025-05-01"),
                Food("🥐 Croissant", 2.8, 50, "2024-02-09"),
            ],
        }

    def get_products_for_category(self, category_name):
        return self.products.get(category_name, [])

    def get_cart_items(self):
        return self.user.shopping_cart.cart  # Используется итератор корзины

    def get_total_price(self):
        return self.user.shopping_cart.calculate_total()

    def add_to_cart(self, product, quantity):
        self.user.shopping_cart.add_to_cart(product, quantity)

    def remove_from_cart(self, product_name):
        self.user.shopping_cart.remove_from_cart(product_name)

    def process_payment(self):
        total_price = self.get_total_price()
        if total_price > 0:
            message = f"Thanks for your purchase! Amount to be paid: ${total_price:.2f}"
            self.user.shopping_cart.cart.clear()
        else:
            message = "Your cart is empty."

        return message
