This is a console-based program that allows you to test some proxy-like functions for 
controlling the downloading of web resources. The program implements the following options:

Denying access to URLs based on a list of blocked sites that can be added/removed dynamically
Denying access to resources of type image
Denying access to resources of type HTML
Denying access to resources containing cookies

The list of blocked sites is saved to a text file named blocked.txt. There should be one URL
per line, and the program loads the list of blocked sites at startup if it exists.
The list should not contain duplicates. A URL is blocked if it appears in the list or if 
any URL matches the beginning of the URL. For example, if http://x.y.z is blocked, 
http://x.y.z/hello should also be blocked.


Commands
The program supports the following commands:

b <url>: block a URL and add it to the list of blocked URLs saved in blocked.txt.
For example: b https://en.wikipedia.org/wiki/Main_Page
The program checks the URL syntax compliant with RC 2396 and prints "invalid URL" if the
given URL is invalid.
The program does not check the connectivity of the URL.
If blocked.txt does not exist, it is created.
u <url>: unblock a URL and update the list in blocked.txt.
For example: u https://en.wikipedia.org/wiki/Main_Page
The program is silent if the URL was not blocked.
p: prints the current list of blocked sites in alphabetical order.
q: exit the program.
d <-options> <url> <out>: download the contents of a given URL to a file according to the denying options defined by one character code.
Before actual execution, the program catches command syntax errors such as unknown command or wrong number of arguments (invalid command), 
then if syntax is OK, URL validity errors (invalid URL), then if URL is OK, options syntax errors for the download command (invalid option).
Note that the optional list of options must start with a "-" if present ("- " alone is valid).
Denying options are applied in the given order. If a URL is both blocked and unreachable as is (HTTP status != 200), the output will depend on the order of options. For example, -bi will print "denied" while -ib could print "401".
The program provides the following options:
-i: block images (HTTP header Content-Type starts with "image/").
-c: block HTTP responses containing cookies (in HTTP headers response).
-h: block HTML documents (HTTP header Content-Type == "text/html").
-b: deny access to blocked sites.
If a URL is blocked (by -b, -c, or -h), the command prints "denied".
If a URL is not reachable (HTTP response 4XX or 5XX), the program prints the HTTP status code (e.g., "503").
The program outputs "invalid URL" if the.
