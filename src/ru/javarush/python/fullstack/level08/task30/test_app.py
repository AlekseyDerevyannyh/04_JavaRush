import unittest
from flask_testing import TestCase
from app import app, db, User


class TestRegistrationAPI(TestCase):

    def create_app(self):
        app.config['TESTING'] = True
        # Test database: SQLite in memory, separate from the working users.db
        app.config['SQLALCHEMY_DATABASE_URI'] = 'sqlite:///:memory:'
        return app

    def setUp(self):
        db.create_all() # Create tables in the test database before each test

    def tearDown(self):
        db.session.remove()
        db.drop_all()  # Drop the test database after each test

    def test_successful_registration(self):
        response = self.client.post('/register', json={
            'username': 'testuser',
            'password': 'testpassword'
        })
        self.assertEqual(response.status_code, 201)
        self.assertEqual(response.json, {'message': 'User registered successfully'})
        self.assertEqual(User.query.filter_by(username='testuser').count(), 1)

    def test_registration_without_username(self):
        response = self.client.post('/register', json={
            'password': 'testpassword'
        })
        self.assertEqual(response.status_code, 400)
        self.assertEqual(response.json, {'message': 'Username and password required'})
        self.assertEqual(User.query.count(), 0)

    def test_duplicate_registration(self):
        # First registration should succeed
        self.client.post('/register', json={
            'username': 'testuser',
            'password': 'testpassword'
        })

        # Duplicate registration should fail
        response = self.client.post('/register', json={
            'username': 'testuser',
            'password': 'testpassword'
        })

        self.assertEqual(response.status_code, 409)
        self.assertEqual(response.json, {'message': 'User already exists'})


if __name__ == '__main__':
    unittest.main()
