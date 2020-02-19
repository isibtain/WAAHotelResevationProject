BROgrammers - MyHotel_README

=> First create a database with name "brogrammers" and root password "5267" (Change as neccesary) and Run the program on server on any IDE.
=> Used FinalExamJPASecNoXML demo as a base
=> Complete programmatic configuration. No web.xml, dispatcher-servlet.xml, 
=> See com.project.cs545.miu.configuration package for details.

A. CUSTOMER USE CASES ########################################################################################################################

1. Customer Sign Up --------------------------------------------------------------------------------------------------------------------------
	-> Run the program Home page will come up (index.jsp)
	-> Click "Sign Up" option on the top Navigation menu and a Sign up form will come up
	-> Fill in all the required information (All fields are Validated). Follow error messages for formats and requirements
	-> Submit and a success page with login page will come up
	-> Login as a CUSTOMER with credentials

2. Member(Signed up CUSTOMER) Booking --------------------------------------------------------------------------------------------------------
	-> Go to login on home page
	-> Login with credentials from sign up (
	-> A page with Search room options will come up
	-> Fill in desired dates and list of available rooms will come up
	-> Select desired room and a confirm page will come up
	-> No need to fill customer info (because already registered)
	-> Click Confirm Booking and the reservation will be added to the customer
	-> Booking confirmation page with Customer name and Room type will come up

3. Member(Signed up Customer) Manage Booking -------------------------------------------------------------------------------------------------
	-> Login with credentials (use username "Daniel" and password "guest", alredy populated CUSTOMER when program runs)
	-> A page with Search room options and a MANAGE BOOKINGS option will come up
	-> Select manage booking and a list of bookings for the signed in customer will come up
	-> View or 'CANCEL' a booking from the list

2. Guest Customer Booking (No need for Sign Up) ----------------------------------------------------------------------------------------------
	-> Go to home page and select search on top namvigation menu or optional button at the center of the homepage
	-> A page with Search room options will come up
	-> Fill in desired dates and list of available rooms will come up
	-> Select desired room and a customer information page will come up
	-> Fill in all the required information (All fields are Validated). Follow error messages for formats and requirements
	-> Ckick Confirm Booking and the reservation along with the customer info will be saved
	-> Booking confirmation page with Customer name and Room type will come up

B. ADMIN USE CASES ###########################################################################################################################

1. ADMIN Sign Up -----------------------------------------------------------------------------------------------------------------------------
	-> ADMIN cannot be signed up from the homepage like a customer.  
	-> First sign in with existing ADMIN credentials (use username "Kaleb" and password "admin", alredy populated ADMIN when program runs)
	-> An admin page with admin options will come up
	-> Select Manage Users on the admin navigation menu
	-> A sign up form including a list of all users will come up
	-> Fill in all required information including Authority
	-> Select ADMIN Authority to create an admin user and submit
	-> The user will be immediately added and shows up on the list of users below as ADMIN

2. ADMIN resource management -----------------------------------------------------------------------------------------------------------------
	-> Sign in with admin credentials and an ADMIN page with all major admin options will come up 
	   (MANAGE BOOKINGS, MANAGE ROOMS, MANAGE ROOM TYPES, MANAGE VIEW TYPES, MANAGE USERS)
	-> Select any desired function from the admin navigation menu 
	-> Each option will direct to a page that contains a form to add new Resource like ROOM, ROOM TYPE etc and an option to DELETE
	-> Follow validation when filling in the forms
	-> Delete a resource by using the DELETE option on the displayed list for each Item
	-> Deleting a resource which is associated with an existing Parent is not allowed and a message will display. 
	   For example, a ROOM which is used in a current BOOKING cannot be deleted before the BOOKING is deleted.

C. GENERAL USE CASES ###########################################################################################################################

1. Change Language -----------------------------------------------------------------------------------------------------------------------------
	-> Select desired language from bottom footer pane and the prefered language will be set to some functionalities

2. View and add a REVIEW -----------------------------------------------------------------------------------------------------------------------
	-> Click the REVIEW button from any page on the top navigation menu
	-> View existing Reviews and ratings from the available list
	-> Click "Plase add a review" on the REVIEW page to add a new review and a form will show up
	-> Fill in the review form and submit (Follow error messages for formats and requirements)
	-> The review will be saved and added to the review page

D. DATA POPULATION ############################################################################################################################

	-> Database name is "brogrammers" password set to "5267" (Change as neccesary)
	-> Program is set to pre-populate with sample resources for testing in populate.sql file included
	-> it will populate ROOMS, ROOMTYPES, VIEWTYPES, USERS etc  