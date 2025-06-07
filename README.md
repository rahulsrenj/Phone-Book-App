# Phone Book App

A modern Android application to manage your contacts. The app allows users to create, view, update, and delete contacts using a simple and intuitive interface. It features a **ViewPager2**-based navigation to switch between **All Contacts** and **Favorite Contacts**.

This project follows the **MVVM architecture**, utilizes **Room** for local data persistence, and employs **Data Binding** for clean and efficient UI updates.

---

## Features

- View all contacts or favorite contacts using **tabs with ViewPager2**
- Add new contacts with name, number, email, and profile image
- Mark/unmark contacts as favorites
- Edit and delete existing contacts
- Live UI updates using **LiveData** and **Data Binding**
- Local database using **Room**
- Follows **MVVM (Model-View-ViewModel)** architecture

---
## Screenshots

| Home Page | Add Contact | Contact List |
|-----------|-------------|--------------|
| ![Home Page](https://github.com/user-attachments/assets/fcaeb9be-6f85-4141-b3b9-96a4a70c8db9) | ![Add Contact](https://github.com/user-attachments/assets/74a0d3b5-cc10-46f7-9f08-2956c92693af) | ![Contact List](https://github.com/user-attachments/assets/a419990b-1df4-4b45-8203-7cb59e5e109c) |

| Edit Contact | Delete Contact | Favorite Contact |
|--------------|----------------|------------------|
| ![Edit Contact](https://github.com/user-attachments/assets/b52c064d-2c4d-49ff-9fc9-5cfff556cec2) | ![Delete Contact](https://github.com/user-attachments/assets/a76df05a-23ec-4c46-adc9-a18f9c225c86) | ![Favorite Contact](https://github.com/user-attachments/assets/3093540c-2cba-436d-b03a-b238653cc6e8)
 

---
## Tech Stack

- **Language**: Java
- **Architecture**: MVVM
- **Database**: Room (SQLite)
- **UI Components**:
  - RecyclerView
  - ViewPager2 with TabLayout
  - Data Binding
  - ConstraintLayout
- **Lifecycle Components**:
  - ViewModel
  - LiveData

---

## Screens

- **Main Screen**: Tab layout with All Contacts and Favorites
- **Add Contact**: Input form with validation
- **Update Contact**: Modify existing contact details
- **Empty State**: Shows message when no contacts exist

---
### Installation

1. Clone the repository:
   ```bash
   git clone https://github.com/rahulsrenj/Phone-Book-App.git
