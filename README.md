# Manam Foundation Web application
Check Out and Build from Source:

Clone the repository from GitHub:
 $ git clone git@github.com:ManamFoundation/manamfoundation.git

Navigate into the cloned repository directory:
 $ cd manamfoundation
The project uses gradle to build:
 $ gradlew build

Project uses AngularJS:
    Node tasks
    ----------
   1. To Download and install a local node/npm version.
    $ gradlew nodesetup

   2. To Install node packages from package.json.
    $ cd frontend
    $ gradlew npmInstall

   3. To Build the frontend package.
    $ grunt (runs the Gruntfile.js)

    To run the application from CMD
    $ cd ..
    $ gradlew bootRun

 Access the deployed webapp at

     http://localhost:8080/
