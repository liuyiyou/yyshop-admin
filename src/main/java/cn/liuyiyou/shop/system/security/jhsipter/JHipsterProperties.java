package cn.liuyiyou.shop.system.security.jhsipter;

/**
 * @author: liuyiyou.cn
 * @date: 2019/9/26
 * @version: V1.0
 */

import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.PropertySource;
import org.springframework.context.annotation.PropertySources;
import org.springframework.web.cors.CorsConfiguration;

import javax.validation.constraints.NotNull;
import java.util.List;
import java.util.Map;

@ConfigurationProperties(
        prefix = "jhipster",
        ignoreUnknownFields = false
)
@PropertySources({@PropertySource(
        value = {"classpath:git.properties"},
        ignoreResourceNotFound = true
), @PropertySource(
        value = {"classpath:META-INF/build-info.properties"},
        ignoreResourceNotFound = true
)})
public class JHipsterProperties {
    private final JHipsterProperties.Async async = new JHipsterProperties.Async();
    private final JHipsterProperties.Http http = new JHipsterProperties.Http();
    private final JHipsterProperties.Cache cache = new JHipsterProperties.Cache();
    private final JHipsterProperties.Mail mail = new JHipsterProperties.Mail();
    private final JHipsterProperties.Security security = new JHipsterProperties.Security();
    private final JHipsterProperties.Swagger swagger = new JHipsterProperties.Swagger();
    private final JHipsterProperties.Metrics metrics = new JHipsterProperties.Metrics();
    private final JHipsterProperties.Logging logging = new JHipsterProperties.Logging();
    private final CorsConfiguration cors = new CorsConfiguration();
    private final JHipsterProperties.Social social = new JHipsterProperties.Social();
    private final JHipsterProperties.Gateway gateway = new JHipsterProperties.Gateway();
    private final JHipsterProperties.Registry registry = new JHipsterProperties.Registry();
    private final JHipsterProperties.ClientApp clientApp = new JHipsterProperties.ClientApp();
    private final JHipsterProperties.AuditEvents auditEvents = new JHipsterProperties.AuditEvents();

    public JHipsterProperties() {
    }

    public JHipsterProperties.Async getAsync() {
        return this.async;
    }

    public JHipsterProperties.Http getHttp() {
        return this.http;
    }

    public JHipsterProperties.Cache getCache() {
        return this.cache;
    }

    public JHipsterProperties.Mail getMail() {
        return this.mail;
    }

    public JHipsterProperties.Registry getRegistry() {
        return this.registry;
    }

    public JHipsterProperties.Security getSecurity() {
        return this.security;
    }

    public JHipsterProperties.Swagger getSwagger() {
        return this.swagger;
    }

    public JHipsterProperties.Metrics getMetrics() {
        return this.metrics;
    }

    public JHipsterProperties.Logging getLogging() {
        return this.logging;
    }

    public CorsConfiguration getCors() {
        return this.cors;
    }

    public JHipsterProperties.Social getSocial() {
        return this.social;
    }

    public JHipsterProperties.Gateway getGateway() {
        return this.gateway;
    }

    public JHipsterProperties.ClientApp getClientApp() {
        return this.clientApp;
    }

    public JHipsterProperties.AuditEvents getAuditEvents() {
        return this.auditEvents;
    }

    public static class Async {
        private int corePoolSize = 2;
        private int maxPoolSize = 50;
        private int queueCapacity = 10000;

        public Async() {
        }

        public int getCorePoolSize() {
            return this.corePoolSize;
        }

        public void setCorePoolSize(int corePoolSize) {
            this.corePoolSize = corePoolSize;
        }

        public int getMaxPoolSize() {
            return this.maxPoolSize;
        }

        public void setMaxPoolSize(int maxPoolSize) {
            this.maxPoolSize = maxPoolSize;
        }

        public int getQueueCapacity() {
            return this.queueCapacity;
        }

        public void setQueueCapacity(int queueCapacity) {
            this.queueCapacity = queueCapacity;
        }
    }

    public static class AuditEvents {
        private int retentionPeriod = 30;

        public AuditEvents() {
        }

        public int getRetentionPeriod() {
            return this.retentionPeriod;
        }

        public void setRetentionPeriod(int retentionPeriod) {
            this.retentionPeriod = retentionPeriod;
        }
    }

    public static class Cache {
        private final JHipsterProperties.Cache.Hazelcast hazelcast = new JHipsterProperties.Cache.Hazelcast();
        private final JHipsterProperties.Cache.Caffeine caffeine = new JHipsterProperties.Cache.Caffeine();
        private final JHipsterProperties.Cache.Ehcache ehcache = new JHipsterProperties.Cache.Ehcache();
        private final JHipsterProperties.Cache.Infinispan infinispan = new JHipsterProperties.Cache.Infinispan();
        private final JHipsterProperties.Cache.Memcached memcached = new JHipsterProperties.Cache.Memcached();
        private final JHipsterProperties.Cache.Redis redis = new JHipsterProperties.Cache.Redis();

        public Cache() {
        }

        public JHipsterProperties.Cache.Hazelcast getHazelcast() {
            return this.hazelcast;
        }

        public JHipsterProperties.Cache.Caffeine getCaffeine() {
            return this.caffeine;
        }

        public JHipsterProperties.Cache.Ehcache getEhcache() {
            return this.ehcache;
        }

        public JHipsterProperties.Cache.Infinispan getInfinispan() {
            return this.infinispan;
        }

        public JHipsterProperties.Cache.Memcached getMemcached() {
            return this.memcached;
        }

        public JHipsterProperties.Cache.Redis getRedis() {
            return this.redis;
        }

        public static class Caffeine {
            private int timeToLiveSeconds = 3600;
            private long maxEntries = 100L;

            public Caffeine() {
            }

            public int getTimeToLiveSeconds() {
                return this.timeToLiveSeconds;
            }

            public void setTimeToLiveSeconds(int timeToLiveSeconds) {
                this.timeToLiveSeconds = timeToLiveSeconds;
            }

            public long getMaxEntries() {
                return this.maxEntries;
            }

            public void setMaxEntries(long maxEntries) {
                this.maxEntries = maxEntries;
            }
        }

        public static class Ehcache {
            private int timeToLiveSeconds = 3600;
            private long maxEntries = 100L;

            public Ehcache() {
            }

            public int getTimeToLiveSeconds() {
                return this.timeToLiveSeconds;
            }

            public void setTimeToLiveSeconds(int timeToLiveSeconds) {
                this.timeToLiveSeconds = timeToLiveSeconds;
            }

            public long getMaxEntries() {
                return this.maxEntries;
            }

            public void setMaxEntries(long maxEntries) {
                this.maxEntries = maxEntries;
            }
        }

        public static class Hazelcast {
            private int timeToLiveSeconds = 3600;
            private int backupCount = 1;
            private final JHipsterProperties.Cache.Hazelcast.ManagementCenter managementCenter = new JHipsterProperties.Cache.Hazelcast.ManagementCenter();

            public Hazelcast() {
            }

            public JHipsterProperties.Cache.Hazelcast.ManagementCenter getManagementCenter() {
                return this.managementCenter;
            }

            public int getTimeToLiveSeconds() {
                return this.timeToLiveSeconds;
            }

            public void setTimeToLiveSeconds(int timeToLiveSeconds) {
                this.timeToLiveSeconds = timeToLiveSeconds;
            }

            public int getBackupCount() {
                return this.backupCount;
            }

            public void setBackupCount(int backupCount) {
                this.backupCount = backupCount;
            }

            public static class ManagementCenter {
                private boolean enabled = false;
                private int updateInterval = 3;
                private String url = "";

                public ManagementCenter() {
                }

                public boolean isEnabled() {
                    return this.enabled;
                }

                public void setEnabled(boolean enabled) {
                    this.enabled = enabled;
                }

                public int getUpdateInterval() {
                    return this.updateInterval;
                }

                public void setUpdateInterval(int updateInterval) {
                    this.updateInterval = updateInterval;
                }

                public String getUrl() {
                    return this.url;
                }

                public void setUrl(String url) {
                    this.url = url;
                }
            }
        }

        public static class Infinispan {
            private String configFile = "default-configs/default-jgroups-tcp.xml";
            private boolean statsEnabled = false;
            private final JHipsterProperties.Cache.Infinispan.Local local = new JHipsterProperties.Cache.Infinispan.Local();
            private final JHipsterProperties.Cache.Infinispan.Distributed distributed = new JHipsterProperties.Cache.Infinispan.Distributed();
            private final JHipsterProperties.Cache.Infinispan.Replicated replicated = new JHipsterProperties.Cache.Infinispan.Replicated();

            public Infinispan() {
            }

            public String getConfigFile() {
                return this.configFile;
            }

            public void setConfigFile(String configFile) {
                this.configFile = configFile;
            }

            public boolean isStatsEnabled() {
                return this.statsEnabled;
            }

            public void setStatsEnabled(boolean statsEnabled) {
                this.statsEnabled = statsEnabled;
            }

            public JHipsterProperties.Cache.Infinispan.Local getLocal() {
                return this.local;
            }

            public JHipsterProperties.Cache.Infinispan.Distributed getDistributed() {
                return this.distributed;
            }

            public JHipsterProperties.Cache.Infinispan.Replicated getReplicated() {
                return this.replicated;
            }

            public static class Distributed {
                private long timeToLiveSeconds = 60L;
                private long maxEntries = 100L;
                private int instanceCount = 1;

                public Distributed() {
                }

                public long getTimeToLiveSeconds() {
                    return this.timeToLiveSeconds;
                }

                public void setTimeToLiveSeconds(long timeToLiveSeconds) {
                    this.timeToLiveSeconds = timeToLiveSeconds;
                }

                public long getMaxEntries() {
                    return this.maxEntries;
                }

                public void setMaxEntries(long maxEntries) {
                    this.maxEntries = maxEntries;
                }

                public int getInstanceCount() {
                    return this.instanceCount;
                }

                public void setInstanceCount(int instanceCount) {
                    this.instanceCount = instanceCount;
                }
            }

            public static class Local {
                private long timeToLiveSeconds = 60L;
                private long maxEntries = 100L;

                public Local() {
                }

                public long getTimeToLiveSeconds() {
                    return this.timeToLiveSeconds;
                }

                public void setTimeToLiveSeconds(long timeToLiveSeconds) {
                    this.timeToLiveSeconds = timeToLiveSeconds;
                }

                public long getMaxEntries() {
                    return this.maxEntries;
                }

                public void setMaxEntries(long maxEntries) {
                    this.maxEntries = maxEntries;
                }
            }

            public static class Replicated {
                private long timeToLiveSeconds = 60L;
                private long maxEntries = 100L;

                public Replicated() {
                }

                public long getTimeToLiveSeconds() {
                    return this.timeToLiveSeconds;
                }

                public void setTimeToLiveSeconds(long timeToLiveSeconds) {
                    this.timeToLiveSeconds = timeToLiveSeconds;
                }

                public long getMaxEntries() {
                    return this.maxEntries;
                }

                public void setMaxEntries(long maxEntries) {
                    this.maxEntries = maxEntries;
                }
            }
        }

        public static class Memcached {
            private boolean enabled = false;
            private String servers = "localhost:11211";
            private int expiration = 300;
            private boolean useBinaryProtocol = true;

            public Memcached() {
            }

            public boolean isEnabled() {
                return this.enabled;
            }

            public void setEnabled(boolean enabled) {
                this.enabled = enabled;
            }

            public String getServers() {
                return this.servers;
            }

            public void setServers(String servers) {
                this.servers = servers;
            }

            public int getExpiration() {
                return this.expiration;
            }

            public void setExpiration(int expiration) {
                this.expiration = expiration;
            }

            public boolean isUseBinaryProtocol() {
                return this.useBinaryProtocol;
            }

            public void setUseBinaryProtocol(boolean useBinaryProtocol) {
                this.useBinaryProtocol = useBinaryProtocol;
            }
        }

        public static class Redis {
            private String server = "redis://localhost:6379";
            private int expiration = 300;

            public Redis() {
            }

            public String getServer() {
                return this.server;
            }

            public void setServer(String server) {
                this.server = server;
            }

            public int getExpiration() {
                return this.expiration;
            }

            public void setExpiration(int expiration) {
                this.expiration = expiration;
            }
        }
    }

    public static class ClientApp {
        private String name = "jhipsterApp";

        public ClientApp() {
        }

        public String getName() {
            return this.name;
        }

        public void setName(String name) {
            this.name = name;
        }
    }

    public static class Gateway {
        private final JHipsterProperties.Gateway.RateLimiting rateLimiting = new JHipsterProperties.Gateway.RateLimiting();
        private Map<String, List<String>> authorizedMicroservicesEndpoints;

        public Gateway() {
            this.authorizedMicroservicesEndpoints = JHipsterDefaults.Gateway.authorizedMicroservicesEndpoints;
        }

        public JHipsterProperties.Gateway.RateLimiting getRateLimiting() {
            return this.rateLimiting;
        }

        public Map<String, List<String>> getAuthorizedMicroservicesEndpoints() {
            return this.authorizedMicroservicesEndpoints;
        }

        public void setAuthorizedMicroservicesEndpoints(Map<String, List<String>> authorizedMicroservicesEndpoints) {
            this.authorizedMicroservicesEndpoints = authorizedMicroservicesEndpoints;
        }

        public static class RateLimiting {
            private boolean enabled = false;
            private long limit = 100000L;
            private int durationInSeconds = 3600;

            public RateLimiting() {
            }

            public boolean isEnabled() {
                return this.enabled;
            }

            public void setEnabled(boolean enabled) {
                this.enabled = enabled;
            }

            public long getLimit() {
                return this.limit;
            }

            public void setLimit(long limit) {
                this.limit = limit;
            }

            public int getDurationInSeconds() {
                return this.durationInSeconds;
            }

            public void setDurationInSeconds(int durationInSeconds) {
                this.durationInSeconds = durationInSeconds;
            }
        }
    }

    public static class Http {
        private final JHipsterProperties.Http.Cache cache = new JHipsterProperties.Http.Cache();

        public Http() {
        }

        public JHipsterProperties.Http.Cache getCache() {
            return this.cache;
        }

        public static class Cache {
            private int timeToLiveInDays = 1461;

            public Cache() {
            }

            public int getTimeToLiveInDays() {
                return this.timeToLiveInDays;
            }

            public void setTimeToLiveInDays(int timeToLiveInDays) {
                this.timeToLiveInDays = timeToLiveInDays;
            }
        }
    }

    public static class Logging {
        private boolean useJsonFormat = false;
        private final JHipsterProperties.Logging.Logstash logstash = new JHipsterProperties.Logging.Logstash();

        public Logging() {
        }

        public boolean isUseJsonFormat() {
            return this.useJsonFormat;
        }

        public void setUseJsonFormat(boolean useJsonFormat) {
            this.useJsonFormat = useJsonFormat;
        }

        public JHipsterProperties.Logging.Logstash getLogstash() {
            return this.logstash;
        }

        public static class Logstash {
            private boolean enabled = false;
            private String host = "localhost";
            private int port = 5000;
            private int queueSize = 512;

            public Logstash() {
            }

            public boolean isEnabled() {
                return this.enabled;
            }

            public void setEnabled(boolean enabled) {
                this.enabled = enabled;
            }

            public String getHost() {
                return this.host;
            }

            public void setHost(String host) {
                this.host = host;
            }

            public int getPort() {
                return this.port;
            }

            public void setPort(int port) {
                this.port = port;
            }

            public int getQueueSize() {
                return this.queueSize;
            }

            public void setQueueSize(int queueSize) {
                this.queueSize = queueSize;
            }
        }
    }

    public static class Mail {
        private boolean enabled = false;
        private String from = "";
        private String baseUrl = "";

        public Mail() {
        }

        public boolean isEnabled() {
            return this.enabled;
        }

        public void setEnabled(boolean enabled) {
            this.enabled = enabled;
        }

        public String getFrom() {
            return this.from;
        }

        public void setFrom(String from) {
            this.from = from;
        }

        public String getBaseUrl() {
            return this.baseUrl;
        }

        public void setBaseUrl(String baseUrl) {
            this.baseUrl = baseUrl;
        }
    }

    public static class Metrics {
        private final JHipsterProperties.Metrics.Logs logs = new JHipsterProperties.Metrics.Logs();

        public Metrics() {
        }

        public JHipsterProperties.Metrics.Logs getLogs() {
            return this.logs;
        }

        public static class Logs {
            private boolean enabled = false;
            private long reportFrequency = 60L;

            public Logs() {
            }

            public boolean isEnabled() {
                return this.enabled;
            }

            public void setEnabled(boolean enabled) {
                this.enabled = enabled;
            }

            public long getReportFrequency() {
                return this.reportFrequency;
            }

            public void setReportFrequency(long reportFrequency) {
                this.reportFrequency = reportFrequency;
            }
        }
    }

    public static class Registry {
        private String password;

        public Registry() {
            this.password = JHipsterDefaults.Registry.password;
        }

        public String getPassword() {
            return this.password;
        }

        public void setPassword(String password) {
            this.password = password;
        }
    }

    public static class Security {
        private final JHipsterProperties.Security.ClientAuthorization clientAuthorization = new JHipsterProperties.Security.ClientAuthorization();
        private final JHipsterProperties.Security.Authentication authentication = new JHipsterProperties.Security.Authentication();
        private final JHipsterProperties.Security.RememberMe rememberMe = new JHipsterProperties.Security.RememberMe();

        public Security() {
        }

        public JHipsterProperties.Security.ClientAuthorization getClientAuthorization() {
            return this.clientAuthorization;
        }

        public JHipsterProperties.Security.Authentication getAuthentication() {
            return this.authentication;
        }

        public JHipsterProperties.Security.RememberMe getRememberMe() {
            return this.rememberMe;
        }

        public static class Authentication {
            private final JHipsterProperties.Security.Authentication.Jwt jwt = new JHipsterProperties.Security.Authentication.Jwt();

            public Authentication() {
            }

            public JHipsterProperties.Security.Authentication.Jwt getJwt() {
                return this.jwt;
            }

            public static class Jwt {
                private String secret;
                private String base64Secret;
                private long tokenValidityInSeconds;
                private long tokenValidityInSecondsForRememberMe;

                public Jwt() {
                    this.secret = JHipsterDefaults.Security.Authentication.Jwt.secret;
                    this.base64Secret = JHipsterDefaults.Security.Authentication.Jwt.base64Secret;
                    this.tokenValidityInSeconds = 1800L;
                    this.tokenValidityInSecondsForRememberMe = 2592000L;
                }

                public String getSecret() {
                    return this.secret;
                }

                public void setSecret(String secret) {
                    this.secret = secret;
                }

                public String getBase64Secret() {
                    return this.base64Secret;
                }

                public void setBase64Secret(String base64Secret) {
                    this.base64Secret = base64Secret;
                }

                public long getTokenValidityInSeconds() {
                    return this.tokenValidityInSeconds;
                }

                public void setTokenValidityInSeconds(long tokenValidityInSeconds) {
                    this.tokenValidityInSeconds = tokenValidityInSeconds;
                }

                public long getTokenValidityInSecondsForRememberMe() {
                    return this.tokenValidityInSecondsForRememberMe;
                }

                public void setTokenValidityInSecondsForRememberMe(long tokenValidityInSecondsForRememberMe) {
                    this.tokenValidityInSecondsForRememberMe = tokenValidityInSecondsForRememberMe;
                }
            }
        }

        public static class ClientAuthorization {
            private String accessTokenUri;
            private String tokenServiceId;
            private String clientId;
            private String clientSecret;

            public ClientAuthorization() {
                this.accessTokenUri = JHipsterDefaults.Security.ClientAuthorization.accessTokenUri;
                this.tokenServiceId = JHipsterDefaults.Security.ClientAuthorization.tokenServiceId;
                this.clientId = JHipsterDefaults.Security.ClientAuthorization.clientId;
                this.clientSecret = JHipsterDefaults.Security.ClientAuthorization.clientSecret;
            }

            public String getAccessTokenUri() {
                return this.accessTokenUri;
            }

            public void setAccessTokenUri(String accessTokenUri) {
                this.accessTokenUri = accessTokenUri;
            }

            public String getTokenServiceId() {
                return this.tokenServiceId;
            }

            public void setTokenServiceId(String tokenServiceId) {
                this.tokenServiceId = tokenServiceId;
            }

            public String getClientId() {
                return this.clientId;
            }

            public void setClientId(String clientId) {
                this.clientId = clientId;
            }

            public String getClientSecret() {
                return this.clientSecret;
            }

            public void setClientSecret(String clientSecret) {
                this.clientSecret = clientSecret;
            }
        }

        public static class RememberMe {
            @NotNull
            private String key;

            public RememberMe() {
                this.key = JHipsterDefaults.Security.RememberMe.key;
            }

            public String getKey() {
                return this.key;
            }

            public void setKey(String key) {
                this.key = key;
            }
        }
    }

    public static class Social {
        private String redirectAfterSignIn = "/#/home";

        public Social() {
        }

        public String getRedirectAfterSignIn() {
            return this.redirectAfterSignIn;
        }

        public void setRedirectAfterSignIn(String redirectAfterSignIn) {
            this.redirectAfterSignIn = redirectAfterSignIn;
        }
    }

    public static class Swagger {
        private String title = "Application API";
        private String description = "API documentation";
        private String version = "0.0.1";
        private String termsOfServiceUrl;
        private String contactName;
        private String contactUrl;
        private String contactEmail;
        private String license;
        private String licenseUrl;
        private String defaultIncludePattern;
        private String host;
        private String[] protocols;
        private boolean useDefaultResponseMessages;

        public Swagger() {
            this.termsOfServiceUrl = JHipsterDefaults.Swagger.termsOfServiceUrl;
            this.contactName = JHipsterDefaults.Swagger.contactName;
            this.contactUrl = JHipsterDefaults.Swagger.contactUrl;
            this.contactEmail = JHipsterDefaults.Swagger.contactEmail;
            this.license = JHipsterDefaults.Swagger.license;
            this.licenseUrl = JHipsterDefaults.Swagger.licenseUrl;
            this.defaultIncludePattern = "/api/.*";
            this.host = JHipsterDefaults.Swagger.host;
            this.protocols = JHipsterDefaults.Swagger.protocols;
            this.useDefaultResponseMessages = true;
        }

        public String getTitle() {
            return this.title;
        }

        public void setTitle(String title) {
            this.title = title;
        }

        public String getDescription() {
            return this.description;
        }

        public void setDescription(String description) {
            this.description = description;
        }

        public String getVersion() {
            return this.version;
        }

        public void setVersion(String version) {
            this.version = version;
        }

        public String getTermsOfServiceUrl() {
            return this.termsOfServiceUrl;
        }

        public void setTermsOfServiceUrl(String termsOfServiceUrl) {
            this.termsOfServiceUrl = termsOfServiceUrl;
        }

        public String getContactName() {
            return this.contactName;
        }

        public void setContactName(String contactName) {
            this.contactName = contactName;
        }

        public String getContactUrl() {
            return this.contactUrl;
        }

        public void setContactUrl(String contactUrl) {
            this.contactUrl = contactUrl;
        }

        public String getContactEmail() {
            return this.contactEmail;
        }

        public void setContactEmail(String contactEmail) {
            this.contactEmail = contactEmail;
        }

        public String getLicense() {
            return this.license;
        }

        public void setLicense(String license) {
            this.license = license;
        }

        public String getLicenseUrl() {
            return this.licenseUrl;
        }

        public void setLicenseUrl(String licenseUrl) {
            this.licenseUrl = licenseUrl;
        }

        public String getDefaultIncludePattern() {
            return this.defaultIncludePattern;
        }

        public void setDefaultIncludePattern(String defaultIncludePattern) {
            this.defaultIncludePattern = defaultIncludePattern;
        }

        public String getHost() {
            return this.host;
        }

        public void setHost(String host) {
            this.host = host;
        }

        public String[] getProtocols() {
            return this.protocols;
        }

        public void setProtocols(String[] protocols) {
            this.protocols = protocols;
        }

        public boolean isUseDefaultResponseMessages() {
            return this.useDefaultResponseMessages;
        }

        public void setUseDefaultResponseMessages(boolean useDefaultResponseMessages) {
            this.useDefaultResponseMessages = useDefaultResponseMessages;
        }
    }
}
