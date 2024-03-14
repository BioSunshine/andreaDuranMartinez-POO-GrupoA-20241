from library import Library
from code_generator import CodeGenerator


class Books:

    def __init__(self, identifier, title, author, year):
        self.id = identifier
        self.title = title
        self.author = author
        self.year = year
        self.its_available = True

    @staticmethod
    def register_book():
        title = input("Title: ")
        author = input("Author: ")
        if not title or not author:
            print("Invalid input, please provide correct data")
            return

        year = int(input("Publication year: "))
        if year > 2024:
            print("Invalid input, please verify")
            return

        identifier = CodeGenerator.create_book_id()
        new_book = Books(identifier, title, author, year)
        Library.add_book(new_book)
        print("Book registered successfully")

    def get_year(self):
        return self.year

    def get_id(self):
        return self.id

    def get_title(self):
        return self.title

    def get_author(self):
        return self.author

    def is_its_available(self):
        return self.its_available

    def set_its_available(self, its_available):
        self.its_available = its_available
