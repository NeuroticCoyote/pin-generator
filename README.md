# pin-generator
An application that generates a 4 digit pin number for a particular user.
Rules:
    - Must not have consecutive sequence of numbers (i.e. 1234).
    - Must not have consectuive numbers next to each other (i.e 1122).
    - Must not be a pin number in the users history of past 3 previous pins.
    - Must not contain the account or sort code of the user.
    - Must not be a palindrome (i.e 1221).