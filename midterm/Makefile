TEX = pdflatex -shell-escape -interaction=nonstopmode -file-line-error
BIB = bibtex
OPEN = gio open

.PHONY: all view clean

all : main.pdf

main.pdf : *.tex
	$(TEX) main.tex
	$(TEX) main.tex

view:
	$(OPEN) main.pdf 2>/dev/null

clean:
	rm -rf *.pdf *.aux *.bbl *.blg *.log *.toc *.out
