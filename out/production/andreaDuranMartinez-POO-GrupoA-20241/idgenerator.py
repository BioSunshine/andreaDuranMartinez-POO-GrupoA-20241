import random


class IdGenerator:
    @staticmethod
    def create_id():
        id_number = "24"
        for _ in range(3):
            id_number += str(random.randint(0, 9))
        return id_number

    @staticmethod
    def create_book_id():
        id_number = "12"
        for _ in range(3):
            id_number += str(random.randint(0, 9))
        return id_number
