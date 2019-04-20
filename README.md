# Brainy Stories

Release Notes
- Version 1.1
- New features: Quizzes are now displayed in increments, rather than all at once.
- Bugs fixed: Removed the favorites tab, which crashes the app if selected. Also removed the favorites button. 
- Known bugs and defects: Reward and Pets functionality will not be included upon release. 

Install Guide
- Prerequisites: Android Studio w/ an emulator w/ Android 9, API 28. Download Android Studio: https://developer.android.com/studio. 
- Dependent libraries: glide and circleimageview. These will be automatically installed by gradle when the app is run in Android Studio.  
- Download instructions: Download the application from Github by pressing the green 'Clone or download' button. Unzip the downloaded folder   into a location of your choosing. 
- Installation instructions: In Android Studio, click: File -> New -> Import Project. Select your newly unzipped folder, and click OK. 
- Run instructions: Press the green run button on the top panel (looks like a play button). You will see a window to select an emulator.    The first time you run the app, select 'Create New Virtual Device'. Pick a phone (for example, Nexus 6) and click Next. Click Download next to Pie (Android 9), wait for the download to complete, then click Next. Click Finish. Then select your newly created emulator and click OK.
- Troubleshooting: If any errors are encountered, try the following solutions: 
  - If your error messages mentions insufficient memory, click Tools -> AVD Manager. Then click the pencil-shaped button adjacent to your       emulator of choice. Then click Show Advanced Settings, and increase the internal storage. Try 2000 MB, and add more if you get the same     error.
  - Click Build -> Clean Project, and run the project again.   
  - Close and reopen Android Studio.
