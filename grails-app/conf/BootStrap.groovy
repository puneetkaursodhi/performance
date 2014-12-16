class BootStrap {
    def bootStrapService

    def init = { servletContext ->
        bootStrapService.addSampleData()
    }
    def destroy = {
    }
}
