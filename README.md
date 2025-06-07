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
| ![Home Page](https://github.com/user-attachments/assets/6ef8477f-fc7f-4e56-957e-f44111a21a99) | ![Add Contact](https://github.com/user-attachments/assets/d4a8b75c-56c2-47d5-bb7a-4aac127bb9c0) | ![Contact List](https://github.com/user-attachments/assets/9673a6aa-2ca5-4c9d-b55e-f9e99fe0d54b) |

| Edit Contact | Delete Contact | Favorite Contact |
|--------------|----------------|------------------|
| ![Edit Contact](https://github.com/user-attachments/assets/1f645418-fae5-40d4-a2e1-f2156484788b) | ![Delete Contact](https://github.com/user-attachments/assets/55a7c08a-5471-48e8-afad-24ec7e098a76) | ![Favorite Contact](https://github.com/user-attachments/assets/12125fbc-c965-446d-bfc9-ffd28e6c641c) |

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
