grails.gorm.default.constraints = {
    '*'(nullable: true)
}
grails.gorm.failOnError = true

server.port = 9010
// server.contextPath = '/'

grails.converters.json.default.deep = true  //as json 时可以把里面的对象全部转换成json

grails.sitemesh.default.layout = 'main'
sequence.flushInterval = 60

grails.converters.encoding = 'utf-8'
grails.spring.transactionManagement = true