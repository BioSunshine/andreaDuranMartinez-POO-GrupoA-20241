import random

class IdGenerator:
    def create_id(self):
        id_number = "24"
        for _ in range(3):
            id_number += str(random.randint(0, 9))
        return id_number

    def create_book_id(self):
        id_number = "12"
        for _ in range(3):
            book_number = random.randint(0, 9)
            id_number += str(book_number)
        return id_number
