# Group-20-Shopping-Cart

Group 20 JAVA Shopping Cart was written using Netbeans IDE. To create a .jar file on Netbeans: 
- Open the project directory in netbeans
- Right-click on the Project name
- Select Properties
- Click Packaging
- Check Build JAR after Compiling
- Check Compress JAR File
- Click OK to accept changes
- Right-click on a Project name
- Select Build or Clean and Build

When running the program, it will generate 4 text files:
- Inventory.txt: data on all available items in the store. It will initialize with some items and a bundle.
- Profit.txt: data for revenue, costs, and profit (profit is revenue - costs).
- ID.txt: keeps track of current internal ID of the items.
- User.txt: stores data for user accounts. It will initialize with 4 accounts.

These text files will be updated by the program when new accounts are created, when purchases are made, or when new items are added to the inventory. DO NOT manually modify these files.

When opening the program, it will show the Login page. The user can either create a new account, or login as a customer or seller (Accounts are shared between customers and sellers).

Customer:
- Add items to invoice (if item is out of stock, it cannot be added to the invoice).
- Remove items from invoice.
- Check item info (including available stock)
- Checkout

When checking out, the user is prompted to enter their credit card information. It must follow the correct syntax:
- Credit Card Number: 16 digits long, first digit must 4.
- Credit Card Name: must be not empty.
- Date: must be in the form mm/yy or mmyy.
- cvv: must be 3 digits long.

After making a payment, the revenue is updated.

Seller:
- Create a new item
    *Price field must be number, quantity must be integer, discount must be number between 0 and less than 100 (percentage).
    *If discount is 0, new item is considered a Product. Otherwise it is a DiscountedItem.
    *If the new item is an item that already exists in the inventory, that item's data will be update and no new item is created.
    *Costs are updated after new item is added.
- Create a new bundle
    *items can be added to the bundle using the dropdown combobox. Must specify quantity and discount.
    *Costs are updated after new bundle is added.
- Remove item from inventory
    *If an item that is a part of a bundle or several bundles is removed, those bundles are also recursively removed.
- Check profit, revenue and costs using the "Profits" button.

Customer and Seller can log out at any item and get sent back to login page.
