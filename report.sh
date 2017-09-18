#!/bin/bash

#
#


mvn site &&
xdg-open target/site/surefire-report.html