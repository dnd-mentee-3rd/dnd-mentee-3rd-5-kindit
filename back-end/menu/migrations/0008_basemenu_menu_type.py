# Generated by Django 3.0.2 on 2020-09-06 17:27

from django.db import migrations, models


class Migration(migrations.Migration):

    dependencies = [
        ('menu', '0007_auto_20200907_0211'),
    ]

    operations = [
        migrations.AddField(
            model_name='basemenu',
            name='menu_type',
            field=models.PositiveIntegerField(default='0', verbose_name='메뉴타입'),
        ),
    ]