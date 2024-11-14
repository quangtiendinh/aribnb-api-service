INSERT INTO public.users (username, email, password, phone_number, profile_picture, bio, is_host, created_by, updated_by) VALUES
                                                                                                                              ('john_doe', 'john@example.com', 'password123', '+1234567890', 'profile1.jpg', 'Love to host travelers', TRUE, 'admin', 'admin'),
                                                                                                                              ('jane_smith', 'jane@example.com', 'password456', '+0987654321', 'profile2.jpg', 'Travel enthusiast', FALSE, 'admin', 'admin'),
                                                                                                                              ('host_user', 'host@example.com', 'password789', '+1122334455', 'profile3.jpg', 'Experienced host', TRUE, 'admin', 'admin'),
                                                                                                                              ('guest_user', 'guest@example.com', 'guestpass', '+9988776655', NULL, 'Looking for great places to stay', FALSE, 'admin', 'admin');

INSERT INTO public.locations (country, city, state, address, postal_code, latitude, longitude, created_by, updated_by) VALUES
                                                                                                                           ('USA', 'New York', 'NY', '123 Main St', '10001', 40.712776, -74.005974, 'admin', 'admin'),
                                                                                                                           ('France', 'Paris', 'Île-de-France', '456 Rue de Paris', '75001', 48.856613, 2.352222, 'admin', 'admin'),
                                                                                                                           ('Japan', 'Tokyo', 'Tokyo', '789 Tokyo St', '100-0001', 35.682839, 139.759455, 'admin', 'admin');
INSERT INTO public.property_types (name, created_by, updated_by) VALUES
                                                                     ('Apartment', 'admin', 'admin'),
                                                                     ('House', 'admin', 'admin'),
                                                                     ('Villa', 'admin', 'admin');
INSERT INTO public.categories (name, description, created_by, updated_by) VALUES
                                                                              ('Family', 'Suitable for family stays', 'admin', 'admin'),
                                                                              ('Luxury', 'Luxurious amenities and comfort', 'admin', 'admin'),
                                                                              ('Budget', 'Affordable places to stay', 'admin', 'admin');
INSERT INTO public.listings (host_id, title, description, property_type_id, guests, bedrooms, bathrooms, beds, price_per_night, cleaning_fee, location_id, created_by, updated_by) VALUES
                                                                                                                                                                                       (1, 'Cozy Apartment in NYC', 'A cozy place in the heart of New York City', 1, 4, 2, 1, 2, 150.00, 20.00, 1, 'admin', 'admin'),
                                                                                                                                                                                       (3, 'Luxury Villa in Paris', 'Experience luxury in the heart of Paris', 3, 8, 4, 3, 5, 500.00, 50.00, 2, 'admin', 'admin'),
                                                                                                                                                                                       (1, 'Modern House in Tokyo', 'Comfortable house in Tokyo with modern amenities', 2, 6, 3, 2, 3, 300.00, 30.00, 3, 'admin', 'admin');
INSERT INTO public.listings_categories (listing_id, category_id, created_by, updated_by) VALUES
                                                                                             (1, 2, 'admin', 'admin'), -- Cozy Apartment in NYC categorized as Luxury
                                                                                             (2, 1, 'admin', 'admin'), -- Luxury Villa in Paris categorized as Family
                                                                                             (3, 3, 'admin', 'admin'); -- Modern House in Tokyo categorized as Budget
INSERT INTO public.photos (listing_id, url, description, is_cover, created_by, updated_by) VALUES
                                                                                               (1, 'nyc_apartment.jpg', 'Living room view', TRUE, 'admin', 'admin'),
                                                                                               (2, 'paris_villa.jpg', 'Front view of the villa', TRUE, 'admin', 'admin'),
                                                                                               (3, 'tokyo_house.jpg', 'Bedroom view', FALSE, 'admin', 'admin');
INSERT INTO public.reservations (listing_id, guest_id, check_in, check_out, guests_count, total_price, status, created_by, updated_by) VALUES
                                                                                                                                           (1, 4, '2024-12-01', '2024-12-05', 2, 680.00, 'CONFIRMED', 'admin', 'admin'),
                                                                                                                                           (2, 2, '2024-12-10', '2024-12-15', 5, 2750.00, 'PENDING', 'admin', 'admin'),
                                                                                                                                           (3, 4, '2024-12-20', '2024-12-25', 3, 1590.00, 'CANCELLED', 'admin', 'admin');
