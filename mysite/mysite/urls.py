from django.conf.urls import patterns, include, url
from rest_framework import routers
from polls import views

from django.contrib import admin
admin.autodiscover()

router = routers.DefaultRouter()
router.register(r'polls', views.PollViewSet)

urlpatterns = patterns('',
    # Examples:
    # url(r'^$', 'mysite.views.home', name='home'),
    # url(r'^blog/', include('blog.urls')),
    url(r'^polls', include(router.urls)),
     url(r'^', include('snippets.urls')),
    url(r'^admin/', include(admin.site.urls)),
    url(r'^api-auth/', include('rest_framework.urls', namespace='rest_framework'))

)
