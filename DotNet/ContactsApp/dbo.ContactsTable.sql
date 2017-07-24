CREATE TABLE [dbo].[ContactsTable]
(
	[ID] INT NOT NULL PRIMARY KEY IDENTITY, 
    [FirstName] VARCHAR(50) NULL, 
    [LastName] VARBINARY(50) NULL, 
    [Address] VARBINARY(400) NULL, 
    [PhoneNumber] VARBINARY(50) NULL, 
    [Email] VARBINARY(50) NULL
)
