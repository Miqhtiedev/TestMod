# How to create a mod (BASICS)

- All code for this project is within this repository!
- This guide assumes that you have a basic understanding of java

## Part 1: Setup

- Setting up the mod is probably the hardest part about coding minecraft mods. Please follow these steps exactly how they are so you do not run into any issues. In addition to that I am using intellij for this tutorial, you can download the IDE here: https://www.jetbrains.com/idea/download/#sectio


### Step 1: Download forge mdk. This tutorial is for 1.8.9 so the download for the mdk is here: http://www.mediafire.com/file/584objjlocv3x4w/file

### Step 2: Create a new folder for the mod and then drag the contents of the mdk into the new folder. 
![New Folder](https://i.imgur.com/lIffag9.png)

### Step 3: Remove all files that we do not need. The files to remove are

- Eclipse
- .gitignore
- CREDITS-fml
- forge-1.8.9-somenumber-changelog
- LICENSE-fml
- MinecraftForge-Credits and MinecraftForge-License
- Paulscorde IBXM ibrary License
- Paulscode SoundSystem CodecIBXM License
- README

Here is a picture of all the files left

![Files Left](https://i.imgur.com/Rp1yyr0.png)

### Step 4: Open the project

- Launch Intellij and then click Open or Import
- Find the folder that contains the project and click it
- Click the "OK" button

Picture

![Open Project](https://i.imgur.com/CtynwlA.png)

### Step 5: Open the gradle tab
- Pretty self explanitory, just find the tab on the far left or right of the IDE that says gradle and click 

NOTE: The location of the tab may change. If it is not where it is in the picture be sure to check both sides of the IDE

Picture

![Open Tab](https://i.imgur.com/iIogXB1.png)


### Step 6: Refresh Project
NOTE: There is a possibilty that you get an error while doing this. If you do please look at step 6.5

Picture

![Refresh Project](https://i.imgur.com/k8WIlos.png)


### Step 6.5 (If you get an error with step 6)
Picture

![Error](https://i.imgur.com/M8Ndvtr.png)
#### After you finish this step please repeat step 6

### Step 7: Open build.gradle file
- Open the project tab (similar to step 5 but project instead of gradle)
- Locate the build.gradle file

Picture

![build.gradle](https://i.imgur.com/TR18Jiv.png)

### Step 8: Edit build.gradle
- In the build.gradle file scroll down until you find the picture below.
- Change the string in group to equal your package + the modid. If you own a website you will make the package (com.website.modid) example I own miqhtie.com so for me it would be com.miqhtie.modid; your modid is basically just the name of the mod in lowercase without any spaces. The name of this mod is test mod so the mod id will be testmod. If I combine the 2 the new value for the group variable is com.miqhtie.testmod
- Change the string in archivesBaseName to equal your modid.

Picture

![Edit build file](https://i.imgur.com/ecB8rN4.png)

### Step 9: Reload your project
- It is good practice to reload the project every time you edit the build.gradle file. Please look at the picture below to see how to do so

Picture

![Reload Project](https://i.imgur.com/GzNoQj6.png)

### Step 10: Open mcmod.info file

Picture

![Open mcmod info file](https://i.imgur.com/x9LAfhV.png)

### Step 11: Edit mcmod.info file
- This step is pretty simple. Just change the values in side of the second set of "" to what is should be.

Picture

![Edit mcmod info file](https://i.imgur.com/NY877w9.png)

### Step 12: Rename the package
- By default the package name is com.example.examplemod but that is not what we want. We need to change the package to our own. (In my case it is com.miqhtie.testmod)

Picture

![Rename Package](https://i.imgur.com/YcfX6g5.png)
![Rename Package 2](https://i.imgur.com/5dZLFfx.png)

### Step 13: Rename the class
- Similar to how we renamed te package we now need to rename the ExampleMod class into our TestMod class
- First expand out new package and find the ExampleMod file, then right click, refactor, rename and rename it to "TestMod"

Picture

![Rename The Class](https://i.imgur.com/SumsKZ9.png)

### If you have made it this far, good job! Now that we finished the hardest part we can move on to the fun part, coding!

## Part 2: Coding

### Step 1: The default code
- In the picture below you will see all the default code
- The @Mod is what tells forge that this is a mod. Without that everything will break
- the final strings MODID and VERSION are just some simple variables. Make sure to switch the values of them to apply for you
- Finally the @EventHandler public void init(FMLInitializationEvent event) is an event that is trigged while the mod is starting up.

![Deafult Code](https://i.imgur.com/iYs4Xhx.png)

### Step 3: The mod

- In this step we will be coding the mod. The mod that we will be making is a mod that gets the chat messages and if the chat message contains "poop" it replaces that part of the message with "blocked-word"
- First we need to detect when there is a chat message. To do so we need to make a @SubscriveEvent public void chat(ClientChatRecievedEvent event){}
- Now we need to register all the events within the class. To do so head over to the init method and inside there add this code: "MinecraftForge.EVENT_BUS.register(this);"
- Now we can code all the stuff in the chat event. First lets make sure to not run any of the code unless the message actually contains the blocked word. Doing that is simple, just add this code: "if(!event.message.getUnformattedText().toLowerCase().contains("poop")) return;"
- If the message contains the word in the event we need to cancel the event so the player does not recieve the message at all. For that we can do event.setCanceled(true);
- Now we need to send the player an exact copy of that message but with the word poop repleaced with blocked-word. To do that simply add this code:

String newMsg = event.message.getFormattedText().replaceAll("(?i)poop", "blocked-word");

Minecraft.getMinecraft().thePlayer.addChatComponentMessage(new ChatComponentText(newMsg));

Picture

![New Code](https://i.imgur.com/Bj5vtbJ.png)

### Step 4: Building the mod
- Our code is done! Yay! But how do we transfer all the code into a .jar file that we can put into the mods folder? Building the mod! 
- To build the mod open the gradle tab > TestMod > Tasks > Build and then run the "build" task

Picture

![Building the mod](https://i.imgur.com/8m1hU0r.png)

### Step 5: Moving the mod into our mods folder
- Just look at the picture!

Picture
![Moving Mod](https://i.imgur.com/LquLfqL.png)

### Step 6: It works!
- Now that the mod is done you can use the skills taught here to make your own mods! In the future I will expand on this and give instructions on how to make commands, and more complex things. For now though if you ever need something your best friend is google!

Picture

![It Works](https://i.imgur.com/mexnM46.png)
