[![](https://github.com/fmi-basel/faim-ij1-io/actions/workflows/build-main.yml/badge.svg)](https://github.com/fmi-basel/faim-ij1-io/actions/workflows/build-main.yml)

[![SciJava CI](https://github.com/fmi-basel/faim-ij1-io/actions//workflows/.gitaction.yml/badge.svg)](https://github.com/fmi-basel/faim-ij1-io/actions//workflows/.gitaction.yml)

# faim-ij1-io

A simple ImageJ2/SciJava wrapper for reading and writing TIFF (and similar) files through IJ1

This repository is a minimal wrapper around the ImageJ1 TIFF IO functions (namely `IJ.openImage` and `FileSaver#saveAsTiff`)
to make them available as `headless`-compatible SciJava commands.

This component mainly exists because of two long-standing issues:

* Poor handling of Metamorph nd/stk datasets by bio-formats
  * https://github.com/ome/bioformats/pull/3032
  * https://github.com/ome/bioformats/issues/3578
  * https://github.com/ome/bioformats/pull/3586
* Poor TIFF reading/writing performance of SCIFIO
  * https://github.com/scifio/scifio/issues/7
  * https://github.com/scifio/scifio/issues/310

So in order to make KNIME workflows using one or both of the above have an (at least) acceptable performance :cry:, we need to fall back to ImageJ1 IO.
