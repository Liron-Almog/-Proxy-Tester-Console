
# Introduction
created a console-based program to test some proxy-like functions that control the downloading of URL resources from the web.

The program will implement the following options:

denying access to URLs based on a list of blocked sites that can be added/removed dynamically
denying access to resources of type image
denying access to resources of type html
denying access to resources containing cookies
Program options
List of blocked sites
The list of blocked sites will be saved to a TEXT file named “blocked.txt" (define it as static so it can easily be changed). There should be one URL per line. The program should load at startup the list of blocked sites previously saved if any. The list should not contain duplicates. A URL should be blocked if it appears in the list or if any URL matches the beginning of the URL. For example if http://x.y.z is blocked, http://x.y.z/hello should be blocked.

Console based commands
The following console-based commands should be implemented:

b <url>: block a URL, adds the URL to the list of blocked URL saves to the file. For example: b https://en.wikipedia.org/wiki/Main_Page
It should first check the URL syntax (compliant with RC 2396), and print “invalid URL” in case the given URL is invalid
It should not check the connectivity of the URL (the URL might not be reachable at this point).
If the file blocked.txt does not exist, it should be created.
It should deal with the file I/O errors as described (*)
u <url>: unblock the URL and updates the file. For example: u https://en.wikipedia.org/wiki/Main_Page
Should be silent if URL was not blocked.
It should deal with the file I/O errors as described (*)
p: prints the current list of blocked site, alphabetically ordered. It should deal with the file I/O errors as described (*)
q: exit the program
d <-options> <url> <out>: download the given url contents to a file out according to denying options defined by one character code. See command examples below.
Before actual execution command errors: you should first catch command syntax error such as unknown command or wrong number of args (invalid command), then if syntax is ok, URL validity errors (invalid URL), then if URL is ok, options syntax errors for the download command (invalid option). Note that the optional <list of options> must start with a “-“ if present ( “-“ alone is valid).

Denying options
i: block images (HTTP header Content-Type starts with “image/”)
c: block http responses containing cookies (in HTTP headers response)
h: block html document (HTTP header Content-Type == “text/html”)
b: deny access to blocked sites uless any I/O error occurs with the blocked.txt file, must output error to console as described (*)
If a URL is blocked (by b/c/h/i) the command should simply print “denied”. If a URL is not reachable (HTTP response 4XX or 5XX), it prints the http status code for example “503”. Denying options are applied in the given order. If a URL is both blocked and unreachable as is (http status != 200), the output will depend on the order of options. For example -bi will print denied while -ib could print “401”.

Examples of downloading commands
d -b https://en.wikipedia.org/wiki/Main_Page wiki.html: downloads the URL to
