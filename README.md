# JDACommands

### Easy commands integration to JDA.
### *Current version:* **0.1.0**

## Get started with JDACommands
- Step 1: Download this repo.
- Step 2: Create a zip archive and add this folder structure: "ca/tristan/jdacommands/"
- Step 3: Copy the java classes in the target folder.
- Step 4: Paste the copied classes in to the zip archive inside of "jdacommands" folder.
- Step 5: You can now close the zip archive, change it to a JAR file and add it to your project libraries.
- Done.

## How to use
*Main class*
```java
JDACommands jdaCommands = new JDACommands(*prefix*);
```
- *Create new class implementing ICommandExecutor*
*Main class*
```java
jdaCommands.registerCommand(new *YourClass*());

JDABuilder.create(....)...addEventListeners(jdaCommands).build();
```
