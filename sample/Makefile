SRC    := library-catalog.xml
XSL    := transform.xsl
DST    := booklist.txt

.PHONY: usage
usage:
	# make [test|clean]

.PHONY: test
test: $(DST)
	diff -u --strip-trailing-cr library-catalog.txt $(DST)
	# ---- dump begin ------------------------------------------
	@cat $(DST)
	# ---- dump end --------------------------------------------

$(DST): $(SRC) $(XSL)
	xsltpf -t $(XSL) <$(SRC) >$@

.PHONY: clean
clean:
	$(RM) $(DST)
