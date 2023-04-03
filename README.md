This is a console-based program that allows you to test some proxy-like functions for controlling the downloading of web resources. The program implements the following options:

Denying access to URLs based on a list of blocked sites that can be added/removed dynamically
Denying access to resources of type image
Denying access to resources of type HTML
Denying access to resources containing cookies

The list of blocked sites is saved to a text file named blocked.txt. There should be one URL per line, and the program loads the list of blocked sites at startup if it exists. The list should not contain duplicates. A URL is blocked if it appears in the list or if any URL matches the beginning of the URL. For example, if http://x.y.z is blocked, http://x.y.z/hello should also be blocked.
